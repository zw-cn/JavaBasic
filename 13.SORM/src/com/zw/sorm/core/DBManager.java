package com.zw.sorm.core;

import com.zw.sorm.bean.Configuration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: JavaBasic
 * @description: 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author: zw-cn
 * @create: 2020-03-13 16:36
 */
public class DBManager {
    private static Configuration conf;
    private static DBConnectionPool pool;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"),"utf8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new Configuration();
        conf.setCurrentDB(properties.getProperty("currentDB"));
        conf.setCurrentSrcPath(properties.getProperty("currentSrcPath"));
        conf.setDriver(properties.getProperty("driver"));
        conf.setPassword(properties.getProperty("password"));
        conf.setTargetPackage(properties.getProperty("targetPackage"));
        conf.setUrl(properties.getProperty("url"));
        conf.setUser(properties.getProperty("user"));
        conf.setQueryClass(properties.getProperty("queryClass"));
        conf.setPoolMaxSize(Integer.valueOf(properties.getProperty("poolMaxSize")));
        conf.setPoolMinSize(Integer.valueOf(properties.getProperty("poolMinSize")));

        //初始化类信息
        System.out.println("初始化类信息->"+TableContext.class);
        System.out.println("初始化连接池类信息->"+DBConnectionPool.class);
    }
    /**
     * @param
     * @description: 通过数据库连接池获取连接
     * @return: java.sql.Connection
     * @author: zw-cn
     * @time: 3/24/2020 10:57 AM
     */
    public static Connection getConnection(){
        return pool.getPoolConnection();//使用连接池
        //return createConnection();//不使用连接池
    }
    public static void releaseConnection(Connection conn){
        pool.releaseConnection(conn);
    }

    public static Connection createConnection(){
        try {
            Class.forName(conf.getDriver());
            //目前直接建立连接，后期增加连接池处理，以提高效率
            return DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Configuration getConf() {
        return conf;
    }
}
