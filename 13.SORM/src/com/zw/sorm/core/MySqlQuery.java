package com.zw.sorm.core;

import com.zw.sorm.bean.ColumnInfo;
import com.zw.sorm.bean.TableInfo;
import com.zw.sorm.po.U_user;
import com.zw.sorm.utils.JDBCUtils;
import com.zw.sorm.utils.ReflectUtils;
import com.zw.sorm.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: Mysql查询实现Query接口
 * @author: zw-cn
 * @create: 2020-03-14 15:27
 */
public class MySqlQuery implements Query {
    @Override
    public int executeDML(String sql, Object... params) {
        int count = 0;
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            JDBCUtils.handleParams(ps, params);
            System.out.println("MySqlQuery.executeDML->" + ps);
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void insert(Object object) {
        Class c = object.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        Field[] fields = c.getDeclaredFields();
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTableName() + " (");
        int notNullFiled = 0;//不为空的属性值
        List<Object> params = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName, object);

            if (fieldValue != null) {
                sql.append(fieldName + ",");
                notNullFiled++;
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');

        sql.append(" values (");
        for (int i = 0; i < notNullFiled; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');
        executeDML(sql.toString(), params.toArray());
    }

    @Override
    public void delete(Class clazz, Object id) {
        //Emp.class,2-->delete from emp where id = 2
        //通过Class对象获取TableInfo
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(clazz);
        ColumnInfo primaryKey = tableInfo.getPrimaryKey();

        String sql = "delete from " + tableInfo.getTableName() + " where " + primaryKey.getColumnName() + "= ?";
        executeDML(sql, id);
    }

    @Override
    public void delete(Object object) {
        Class c = object.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        System.out.println(TableContext.getPOClassTableMap());
        ColumnInfo columnInfo = tableInfo.getPrimaryKey();

        //通过反射机制，调用属性对应的get方法
        Object key = ReflectUtils.invokeGet(columnInfo.getColumnName(), object);

        delete(c, key);
    }

    @Override
    public int update(Object obj, String... fieldNames) {
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        ColumnInfo primaryKey = tableInfo.getPrimaryKey();
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("update " + tableInfo.getTableName() + " set ");
        for (String fieldName : fieldNames) {
            Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
            params.add(fieldValue);
            sql.append(fieldName + "=?,");
        }
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("where " + primaryKey.getColumnName() + " = ?");

        params.add(ReflectUtils.invokeGet("id", obj));//设置ID
        return executeDML(sql.toString(), params.toArray());
    }

    @Override
    public List queryRows(String sql, Class clazz, Object... params) {
        List rows = null;
        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = JDBCUtils.handleParams(conn.prepareStatement(sql), params);
             ResultSet rs = ps.executeQuery()
        ) {
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                if (rows == null) {
                    rows = new ArrayList();
                }
                Object rowObj = clazz.getConstructor().newInstance();
                //多列 select uname,age from u_user where id > ? and age < ?
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);

                    //通过反射调用rowObj的set方法
                    ReflectUtils.invokeSet(rowObj, columnName, columnValue);
                }
                rows.add(rowObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public Object queryRow(String sql, Object... params) {
        return null;
    }

    @Override
    public Number queryValue(String sql, Object... params) {
        return null;
    }

    public static void main(String[] args) {
        MySqlQuery query = new MySqlQuery();
        List list = query.queryRows("select name from u_user where id>? and regDate <?",U_user.class,20,"2020-3-3");
        System.out.println(list);
    }

    public static void testDML() {
        U_user user = new U_user();
        //user.setId(25);
        MySqlQuery query = new MySqlQuery();
        //query.delete(user);
        user.setName("666444");
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        //query.insert(user);
        user.setId(22);
        query.update(user, new String[]{"name", "lastLogin"});
    }
}
