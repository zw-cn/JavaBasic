package com.zw.jdbc;

import com.zw.jdbc.tools.JDBCUtils;
import com.zw.jdbc.tools.Utils;

import java.sql.Connection;

/**
 * @program: JavaBasic
 * @description: 封装JDBC操作
 * @author: zw-cn
 * @create: 2020-03-13 12:01
 */
public class JDBC_01_Basic_09_Packaging {
    public static void main(String[] args) {

        Connection connection = JDBCUtils.getMysqlConnection();
        System.out.println(connection);
        Utils.closeThem(connection);
    }
}
