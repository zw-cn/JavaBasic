package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.sql.*;

/**
 * @program: JavaBasic
 * @description: ResultSet的基本使用
 * @author: zw-cn
 * @create: 2020-03-12 12:15
 */
public class JDBC_01_Basic_03_ResultSet {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase", "root", "123456");
            String pSql = "select id,name,age,regDate from User";
            ps = connection.prepareStatement(pSql);
            System.out.println(ps.execute());//返回resultSet->true,否则->false
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("id->" + rs.getInt(1) +
                        ",name->" + rs.getString("name") +
                        ",age->" + rs.getInt(3)+
                        ",registerDate->" + rs.getDate(4));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            Utils.closeThem(rs,ps,connection);
        }
    }
}
