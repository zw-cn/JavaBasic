package com.zw.sorm.core;

/**
 * @program: JavaBasic
 * @description: 负责Java数据类型和数据库数据类型的互相转化
 * @author: zw-cn
 * @create: 2020-03-13 16:26
 */
public interface TypeConvertor {
    /**
     * @param columnType 数据库字段的类型
     * @description: 将数据库类型转化成Java的数据类型
     * @return: java.lang.String Java的数据类型
     * @author: zw-cn
     * @time: 3/13/2020 4:30 PM
     */
    String databaseType2JavaType(String columnType);

    /**
     * @param javaType Java的数据类型
     * @description: 将Java数据类型转化成数据库类型
     * @return: java.lang.String 数据库字段的类型
     * @author: zw-cn
     * @time: 3/13/2020 4:32 PM
     */
    String javaType2DatabaseType(String javaType);
}
