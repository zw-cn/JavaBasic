package com.zw.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 表信息
 * @author: zw-cn
 * @create: 2020-03-13 15:44
 */
public class TableInfo {
    /*
     *表名
     */
    private String tableName;
    /*
    * 所有字段的信息
     */
    private Map<String, ColumnInfo> columns;
    /*
    * 唯一主键（目前仅支持单个主键的情况）
     */
    private ColumnInfo primaryKey;

    /*
    联合主键，以备后期
     */
    private List<ColumnInfo> unionPrimaryKey;

    public TableInfo() {
    }

    public TableInfo(String tableName, Map<String, ColumnInfo> columns, ColumnInfo primaryKey, List<ColumnInfo> unionPrimaryKey) {
        this.tableName = tableName;
        this.columns = columns;
        this.primaryKey = primaryKey;
        this.unionPrimaryKey = unionPrimaryKey;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnInfo primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<ColumnInfo> getUnionPrimaryKey() {
        return unionPrimaryKey;
    }

    public void setUnionPrimaryKey(List<ColumnInfo> unionPrimaryKey) {
        this.unionPrimaryKey = unionPrimaryKey;
    }
}
