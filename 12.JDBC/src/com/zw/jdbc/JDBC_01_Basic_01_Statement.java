package com.zw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: JavaBasic
 * @description: JDBC的Statement
 * @author: zw-cn
 * @create: 2020-03-11 17:19
 */
public class JDBC_01_Basic_01_Statement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase","root","123456");
            Statement statement = connection.createStatement();
            String sql = "insert into User (id,name,age) select max(id)+1 ,'Li Xuan',23 from User";
            statement.execute(sql);

            //SQL注入
            String id = "9 or 1=1";
            System.out.println("sql注入:"+"delete from User where id = "+id);
            statement.execute("delete from User where id = "+id);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
