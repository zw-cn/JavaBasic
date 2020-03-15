package com.zw.sorm.bean;

/**
 * @program: JavaBasic
 * @description: 数据库表的列信息（字段信息）
 * @author: zw-cn
 * @create: 2020-03-13 15:43
 */
public class ColumnInfo {
    /*
    * 字段名称
     */
    private String columnName;
    /*
    * 字段的数据类型
     */
    private String dataType;
    /*
    * 字段的键类型
    * 0普通类型，1主键，2外键
     */
    private int keyType;

    public ColumnInfo() {
    }

    public ColumnInfo(String columnName, String dataType, int keyType) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }
}
