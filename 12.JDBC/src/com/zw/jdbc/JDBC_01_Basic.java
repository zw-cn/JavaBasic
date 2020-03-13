package com.zw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: JavaBasic
 * @description: JDBC的基本操作
 * 建立连接（连接对象内部实际上包含了一个Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
 * 真正开发中，为了提高效率，都会使用连接池来管理连接对象！
 * @author: zw-cn
 * @create: 2020-03-11 17:19
 */
public class JDBC_01_Basic {
    public static void main(String[] args) {
        try {
            /*提示
            `com.mysql.jdbc.Driver' is deprecated.
            The new driver class is `com.mysql.cj.jdbc.Driver'.
             */
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase","root","123456");
            long end = System.currentTimeMillis();
            System.out.println("建立连接对象"+connection+"耗时："+(end-start)+"ms");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
