package com.zw.sorm.core;

/**
 * @program: JavaBasic
 * @description: Mysql数据类型和Java数据类型转换器
 * @author: zw-cn
 * @create: 2020-03-13 22:26
 */
public class MysqlTypeConvertor implements TypeConvertor {
    @Override
    public String databaseType2JavaType(String columnType) {
        if ("varchar".equalsIgnoreCase(columnType)
                || "char".equalsIgnoreCase(columnType)) {
            return "String";
        }
        if ("int".equalsIgnoreCase(columnType)
                || "tinyint".equalsIgnoreCase(columnType)
                || "smallint".equalsIgnoreCase(columnType)
                || "integer".equalsIgnoreCase(columnType)) {
            return "Integer";
        }
        if ("bigint".equalsIgnoreCase(columnType)) {
            return "Long";
        }
        if ("float".equalsIgnoreCase(columnType)
                || "double".equalsIgnoreCase(columnType)) {
            return "Double";
        }
        if ("text".equalsIgnoreCase(columnType)
                || "mediumText".equalsIgnoreCase(columnType)
                || "longText".equalsIgnoreCase(columnType)) {
            return "java.sql.Clob";
        }
        if ("blob".equalsIgnoreCase(columnType)
                || "mediumBlob".equalsIgnoreCase(columnType)
                || "longBlob".equalsIgnoreCase(columnType)) {
            return "java.sql.Blob";
        }
        if ("date".equalsIgnoreCase(columnType)) {
            return "java.sql.Date";
        }
        if ("time".equalsIgnoreCase(columnType)) {
            return "java.sql.Time";
        }
        if ("timestamp".equalsIgnoreCase(columnType)) {
            return "java.sql.Timestamp";
        }
        return null;
    }

    @Override
    public String javaType2DatabaseType(String javaType) {
        return null;
    }
}
