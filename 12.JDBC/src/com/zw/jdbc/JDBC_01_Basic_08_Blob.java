package com.zw.jdbc;

import com.zw.jdbc.tools.Utils;

import java.io.*;
import java.sql.*;

import static java.sql.DriverManager.*;

/**
 * @program: JavaBasic
 * @description: Blob的基本使用
 * @author: zw-cn
 * @create: 2020-03-13 09:52
 */
public class JDBC_01_Basic_08_Blob {
    public static void main(String[] args) {
        ResultSet rs = null;
        BufferedInputStream bi = null;
        FileOutputStream fos = null;
        try (Connection connection = getConnection("jdbc:mysql://localhost:3306/JavaBase?characterEncoding=utf-8", "root", "123456");
             PreparedStatement ps1 = connection.prepareStatement("insert into u_user(name ,image) values(?,?)");
             PreparedStatement ps2 = connection.prepareStatement("select image from u_user where name = ?")
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //存储Blob
            ps1.setString(1, "DEF");
            ps1.setBlob(2, new FileInputStream("./12.JDBC/resources/Lake Wanaka, New Zealand.jpg"));
            ps1.executeUpdate();

            //读取Blob
            ps2.setString(1, "DEF");
            rs = ps2.executeQuery();
            while (rs.next()) {
                Blob blob = rs.getBlob(1);
                bi = new BufferedInputStream(blob.getBinaryStream());
                fos = new FileOutputStream("./12.JDBC/resources/Copy Of Lake Wanaka, New Zealand.jpg");
                int len;
                byte[] buffer = new byte[1024];
                while ((len = bi.read(buffer)) != -1) {
                    fos.write(buffer);
                }
                fos.flush();
            }
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Utils.closeThem(fos, bi);
            Utils.closeThem(rs);
        }
    }
}
