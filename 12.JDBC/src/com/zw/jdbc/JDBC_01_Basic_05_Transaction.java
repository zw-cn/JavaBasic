package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.sql.*;

/**
 * @program: JavaBasic
 * @description: 事务
 * @author: zw-cn
 * @create: 2020-03-12 13:23
 */
public class JDBC_01_Basic_05_Transaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase", "root", "123456");
            connection.setAutoCommit(false);

            ps1 = connection.prepareStatement("insert into User(id,name) values (?,?)");
            ps1.setObject(1,19);
            ps1.setObject(2,"张三");
            ps1.execute();
            System.out.println("插入张三");

            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ps2 = connection.prepareStatement("insert into User(id,name) values (?,?,?)");
            ps2.setObject(1,20);
            ps2.setObject(2,"李四");
            ps2.execute();
            System.out.println("插入李四");
            connection.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            Utils.closeThem(ps2,ps1,connection);
        }
    }
}
