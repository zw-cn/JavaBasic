package com.zw.springwithmybatis.test;

import com.zw.springwithmybatis.pojo.Airport;
import com.zw.springwithmybatis.service.AirportService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.springwithmybatis.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com\\zw\\springwithmybatis\\xml\\ApplicationContext.xml");
        //SqlSessionFactory sqlSessionFactory = ac.getBean("SqlSessionFactory", SqlSessionFactory.class);
        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));

        AirportService airportService = ac.getBean("airportService", AirportService.class);
        List<Airport> airports = airportService.airports();
        System.out.println(airports);
    }
}
