package com.zw.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @program: JavaBasic
 * @description: 执行查询模板的回调方法
 * @author: zw-cn
 * @create: 2020-03-23 11:12
 */
public interface CallBack {
    Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs);
}
