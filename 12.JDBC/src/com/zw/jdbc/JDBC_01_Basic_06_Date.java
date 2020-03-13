package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * @program: JavaBasic
 * @description: 日期类java.sql.Date/Time/Timestamp
 * @author: zw-cn
 * @create: 2020-03-12 13:23
 */
public class JDBC_01_Basic_06_Date {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase?characterEncoding=utf-8", "root", "123456");

            for (int i = 0; i < 20; i++) {
                int random = 100000000 + new Random().nextInt(1000000000);
                ps = connection.prepareStatement("insert into u_user(name,regDate,lastLogin) values (?,?,?)");
                ps.setObject(1,"五");
                ps.setDate(2,new java.sql.Date(System.currentTimeMillis()-random));
                ps.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()-random));
                ps.execute();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            Utils.closeThem(ps,connection);
        }
    }
}
