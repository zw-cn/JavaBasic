package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.sql.*;

/**
 * @program: JavaBasic
 * @description: 批处理
 * @author: zw-cn
 * @create: 2020-03-12 12:46
 */
public class JDBC_01_Basic_04_Batch {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase", "root", "123456");
            long start = System.currentTimeMillis();
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            for (int i = 0; i < 20000; i++) {
                stmt.addBatch("insert into User(id,name,age,regDate) values ("+i+",'张"+i+"',18,now())");
            }
            stmt.executeBatch();
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("执行20000条插入，耗时（ms）"+(end-start));//执行20000条插入，耗时（ms）33377

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            Utils.closeThem(stmt,connection);
        }
    }
}
