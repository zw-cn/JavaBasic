package com.zw.jdbc;

import java.sql.*;

/**
 * @program: JavaBasic
 * @description: PreparedStatement的基本使用
 * @author: zw-cn
 * @create: 2020-03-11 22:05
 */
public class JDBC_01_Basic_02_PreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase","root","123456");
            String pSql = "insert into User (id,name,age,regDate) select max(id)+1,?,?,? from User";
            PreparedStatement ps = connection.prepareStatement(pSql);
            ps.setString(1,"张三");
            ps.setInt(2,23);
            ps.setDate(3,new Date(System.currentTimeMillis()));
            ps.execute();

            ps.setObject(1,"Lisi");
            ps.setObject(2,16);
            ps.setObject(3,new Date(System.currentTimeMillis()));
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
