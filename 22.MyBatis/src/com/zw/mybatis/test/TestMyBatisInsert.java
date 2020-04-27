package com.zw.mybatis.test;

import com.zw.traditional.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Title: JavaBasic-com.zw.mybatis.test</p>
 * <p>Description: 测试Mybatis新增</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
public class TestMyBatisInsert {
    public static void main(String[] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = build.openSession();

            Flower flower = new Flower();
            flower.setName("雏菊");
            flower.setPrice(15.0);
            flower.setProduction("中国江西");
            //执行新增
            try {
                session.insert("com.zw.flowers.insertFlower",flower);
            } catch (Exception e) {
                session.rollback();
            }
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
