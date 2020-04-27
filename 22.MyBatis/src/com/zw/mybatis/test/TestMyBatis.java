package com.zw.mybatis.test;

import com.zw.traditional.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.mybatis.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/25/2020
 */
public class TestMyBatis {
//    public static void main(String[] args) throws IOException {
//        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);//获取工厂
//        SqlSession session = factory.openSession();//获取session
//        //进行查询
//        List<Flower> list = session.selectList("com.zw.flowers.selectAll");
//        for (Flower flower : list) {
//            System.out.println(flower);
//        }
//        //关闭session，释放连接
//        session.close();
//    }
}
