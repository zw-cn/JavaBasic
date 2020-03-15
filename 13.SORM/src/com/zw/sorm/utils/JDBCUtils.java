package com.zw.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: JavaBasic
 * @description: 封装JDBC查询常用操作
 * @author: zw-cn
 * @create: 2020-03-13 16:37
 */
public class JDBCUtils {
    public static PreparedStatement handleParams(PreparedStatement ps, Object... params){
        if(params.length > 0){
            for (int i = 0; i < params.length; i++) {
                try {
                    ps.setObject(i+1,params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(ps);
        return ps;
    }

    public static void release(AutoCloseable... resources){
        for (AutoCloseable resource : resources) {
            if (resource != null){
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
