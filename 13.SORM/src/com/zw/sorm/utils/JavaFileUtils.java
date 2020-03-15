package com.zw.sorm.utils;

import com.zw.sorm.bean.ColumnInfo;
import com.zw.sorm.bean.JavaFieldGetSet;
import com.zw.sorm.bean.TableInfo;
import com.zw.sorm.core.DBManager;
import com.zw.sorm.core.MysqlTypeConvertor;
import com.zw.sorm.core.TableContext;
import com.zw.sorm.core.TypeConvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 封装Java文件（源代码）常用操作
 * @author: zw-cn
 * @create: 2020-03-13 16:39
 */
public class JavaFileUtils {
    /**
     * @param column    字段信息
     * @param convertor 类型转化器
     * @description: 根据字段信息生成Java属性信息。如varchar username -> private String username;
     * 以及相应的setter/getter方法
     * @return: com.zw.sorm.bean.JavaFieldGetSet
     * @author: zw-cn
     * @time: 3/13/2020 11:11 PM
     */
    public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
        JavaFieldGetSet jfgs = new JavaFieldGetSet();
        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
        jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getColumnName() + ";\n");

        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getColumnName() + "(){\n"));
        getSrc.append("\t\treturn " + column.getColumnName() + ";\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());

        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getColumnName()) + "(");
        setSrc.append(javaFieldType + " " + column.getColumnName() + "){\n");
        setSrc.append("\t\tthis." + column.getColumnName() + " = " + column.getColumnName() + ";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());

        return jfgs;
    }
    /**
     * @param tableInfo 表信息
     * @param convertor 数据类型转化器
     * @description: 根据表信息去生成Java类的源代码
     * @return: java.lang.String Java类的源代码
     * @author: zw-cn
     * @time: 3/14/2020 9:20 AM
     */
    public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
        Map<String,ColumnInfo> map = tableInfo.getColumns();
        List<JavaFieldGetSet> javaField = new ArrayList<>();

        for (ColumnInfo column : map.values()) {
            javaField.add(JavaFileUtils.createFieldGetSetSRC(column,convertor));
        }

        StringBuilder src = new StringBuilder();
        //生成package
        src.append("package "+ DBManager.getConf().getTargetPackage()+";\n\n");
        //生成import
        src.append("import java.sql.*;\n");
        src.append("import java.util.*;\n");
        src.append("\n");
        //生成类信息
        src.append("public class "+ StringUtils.firstChar2UpperCase(tableInfo.getTableName())+"{\n\n");
        //生成属性信息
        for (JavaFieldGetSet fieldGetSet : javaField) {
            src.append(fieldGetSet.getFieldInfo());
        }
        src.append("\n");
        //生成getter/setter
        for (JavaFieldGetSet getSet : javaField) {
            src.append(getSet.getGetInfo());
            src.append(getSet.getSetInfo());
        }
        //结束类信息
        src.append("}\n");
        return src.toString();
    }

    /**
     * @param tableInfo 表信息
     * @param convertor 类型转化器
     * @description: 根据表信息，类型转化器生成Java源文件到配置文件指定的位置
     * @return: void
     * @author: zw-cn
     * @time: 3/14/2020 12:18 PM
     */
    public static void createJavaFile(TableInfo tableInfo,TypeConvertor convertor){
        String src = createJavaSrc(tableInfo, convertor);
        String path = DBManager.getConf().getCurrentSrcPath()+"/"+(DBManager.getConf().getTargetPackage().replaceAll("\\.","/"));
        File srcFile = new File(path);
        if(! srcFile.exists()){
            srcFile.mkdirs();
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(srcFile.getAbsolutePath()+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTableName())+".java"))) {
            System.out.println("建立表"+tableInfo.getTableName()+"对应的类："+StringUtils.firstChar2UpperCase(tableInfo.getTableName())+".java");
            bw.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param
     * @description: 测试方法createFieldGetSetSRC
     * @return: void
     * @author: zw-cn
     * @time: 3/14/2020 9:32 AM
     */
    public static void testMethodCreateFieldGetSetSRC(){
        ColumnInfo c = new ColumnInfo("name", "int", 0);
        JavaFieldGetSet jfgs = JavaFileUtils.createFieldGetSetSRC(c, new MysqlTypeConvertor());
        System.out.println(jfgs);
    }
    /**
     * @param
     * @description: 测试方法CreateJavaSrc
     * @return: void
     * @author: zw-cn
     * @time: 3/14/2020 11:00 AM
     */
    public static void testMethodCreateJavaSrc(){
        TableInfo tableInfo = TableContext.getDBTableMap().get("u_user");
        String src = createJavaSrc(tableInfo,new MysqlTypeConvertor());
    }
    public static void testCreateJavaFile(){
        TableInfo tableInfo = TableContext.getDBTableMap().get("u_user");
        createJavaFile(tableInfo,new MysqlTypeConvertor());
    }
    public static void main(String[] args) {
        testCreateJavaFile();
    }
}
