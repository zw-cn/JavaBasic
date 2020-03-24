package com.zw.sorm.core;

import com.zw.sorm.utils.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 数据库连接池类
 * @author: zw-cn
 * @create: 2020-03-24 10:43
 */
public class DBConnectionPool {
    public static int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
    public static int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
    private static List<Connection> pool;

    static {
        initPool();
    }

    public static void initPool(){
        if (pool == null){
            pool = new ArrayList<>();
        }
        while (pool.size()<POOL_MIN_SIZE){
            pool.add(DBManager.createConnection());
        }
        System.out.println("DBConnectionPool.initPool->初始化数据库连接，当前池中连接数为："+pool.size());
    }
    public static synchronized Connection getPoolConnection(){
        if (pool.size() <= 0){
            return DBManager.createConnection();
        }
        int lastIndex = pool.size()-1;

        return pool.remove(lastIndex);
    }
    public static synchronized void releaseConnection(Connection connection){
        System.out.println("DBConnectionPool.getPoolConnection start 当前池中连接数为："+pool.size());
        if (pool.size() >= POOL_MAX_SIZE){
            JDBCUtils.release(connection);
        }else {
            pool.add(connection);
        }
        System.out.println("DBConnectionPool.getPoolConnection end 当前池中连接数为："+pool.size());
    }
}
