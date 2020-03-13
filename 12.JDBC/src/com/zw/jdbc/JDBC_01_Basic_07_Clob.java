package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

/**
 * @program: JavaBasic
 * @description: CLOB的基本使用
 * @author: zw-cn
 * @create: 2020-03-12 16:49
 */
public class JDBC_01_Basic_07_Clob {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaBase?characterEncoding=utf-8", "root", "123456");

            //存储Clob
//            ps = connection.prepareStatement("insert into u_user(name ,book) values(?,?)");
//            ps.setString(1,"ABC");
//            ps.setClob(2,new FileReader("./12.JDBC/resources/abc.txt"));
//            ps.executeUpdate();

            //读取Clob
            ps = connection.prepareStatement("select book from u_user where id = 42");
            rs = ps.executeQuery();
            while (rs.next()){
                Clob c = rs.getClob(1);
                BufferedReader br = new BufferedReader(c.getCharacterStream());
                int len;
                char[] buffer = new char[1024];
                StringBuilder sb = new StringBuilder();
                while ((len = br.read(buffer)) != -1){
                    sb.append(buffer);
                }
                System.out.println(sb.toString());
            }

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Utils.closeThem(ps,connection);
        }
    }
}
