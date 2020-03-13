package com.zw.jdbc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: JavaBasic
 * @description: JDBC工具类
 * @author: zw-cn
 * @create: 2020-03-13 11:54
 */
public class JDBCUtils {
    static Properties properties = null;
    static{
        try {
            properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/db.properties"));
            /*
            若将resources文件夹标记为‘resources’，则会将其中的文件全部copy到项目根路径下
             */
            //properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db2.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getMysqlConnection(){
        try {
            Class.forName(properties.getProperty("mysql_Driver"));
            Connection conn = DriverManager.getConnection(properties.getProperty("mysql_URL"),
                    properties.getProperty("mysql_User"),
                    properties.getProperty("mysql_Password"));
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
