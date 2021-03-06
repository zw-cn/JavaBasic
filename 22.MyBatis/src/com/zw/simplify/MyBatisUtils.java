package com.zw.simplify;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Title: JavaBasic-com.zw.simplify</p>
 * <p>Description: 简化模板代码</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if (session == null){
            session = factory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    public static void closeSession(){
        SqlSession session = threadLocal.get();
        if (session != null){
            session.close();
        }
    }
}
