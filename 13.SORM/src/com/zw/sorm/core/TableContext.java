package com.zw.sorm.core;

import com.zw.sorm.bean.ColumnInfo;
import com.zw.sorm.bean.TableInfo;
import com.zw.sorm.utils.JavaFileUtils;
import com.zw.sorm.utils.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 负责管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * @author: zw-cn
 * @create: 2020-03-13 16:34
 */
public class TableContext {
    /*
    key为表名，value为表信息
     */
    private static Map<String, TableInfo> DBTableMap = new HashMap<>();
    /*
    将PO对象和表信息关联起来，便于重用
     */
    private static Map<Class, TableInfo> POClassTableMap = new HashMap<>();

    private TableContext() {
    }

    static {
        //初始化时获得表的信息
        Connection conn = DBManager.getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tableRs = metaData.getTables(null, "%",/*过滤非u_开头的表*/"u\\_%", new String[]{"TABLE"});//
            while (tableRs.next()) {
                String tableName = tableRs.getString("TABLE_NAME");
                TableInfo ti = new TableInfo(tableName, new HashMap<>(), null, new ArrayList<>());
                DBTableMap.put(tableName, ti);

                //查询表中所有字段
                ResultSet columnRs = metaData.getColumns(null, "%", tableName, "%");
                while (columnRs.next()) {
                    ColumnInfo ci = new ColumnInfo(columnRs.getString("COLUMN_NAME"), columnRs.getString("TYPE_NAME"), 0);
                    ti.getColumns().put(columnRs.getString("COLUMN_NAME"), ci);
                }
                //查询主键
                ResultSet primaryRs = metaData.getPrimaryKeys(null, "%", tableName);
                while (primaryRs.next()) {
                    ColumnInfo ci2 = ti.getColumns().get(primaryRs.getString("COLUMN_NAME"));
                    ci2.setKeyType(1);//设置主键类型
                    ti.getUnionPrimaryKey().add(ci2);//添加到联合主键
                }
                if (ti.getUnionPrimaryKey().size() == 1) {//将联合主键的第一个作为主键，如果是联合主键，则为空
                    ti.setPrimaryKey(ti.getUnionPrimaryKey().get(0));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //更新类结构
        uprateJavaPOFiles();

        //更新类与表的映射
        updatePOClassTable();
    }

    public static Map<String, TableInfo> getDBTableMap() {
        return DBTableMap;
    }

    public static Map<Class, TableInfo> getPOClassTableMap() {
        return POClassTableMap;
    }

    /**
     * @param
     * @description: 根据表结构，更新配置的PO包下面的Java类
     * @return: void
     * @author: zw-cn
     * @time: 3/14/2020 12:14 PM
     */
    public static void uprateJavaPOFiles() {
        for (TableInfo tableInfo : DBTableMap.values()) {
            JavaFileUtils.createJavaFile(tableInfo, new MysqlTypeConvertor());
        }
    }

    /**
     * @param
     * @description: 遍历表Map，将class和tableInfo绑定起来
     * @return: void
     * @author: zw-cn
     * @time: 3/14/2020 3:36 PM
     */
    public static void updatePOClassTable() {
        for (TableInfo tableInfo : DBTableMap.values()) {
            try {
                Class c = Class.forName(DBManager.getConf().getTargetPackage() + "." + StringUtils.firstChar2UpperCase(tableInfo.getTableName()));
                POClassTableMap.put(c, tableInfo);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TableContext.getDBTableMap());
    }
}
