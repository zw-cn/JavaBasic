package com.zw.spring.aop.annotation.test;

import com.zw.spring.aop.annotation.advice.Advice;
import com.zw.spring.aop.annotation.demo.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.annotation.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/30/2020
 */
public class AnnoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com\\zw\\spring\\aop\\annotation\\xml\\ApplicationContext.xml");
        Demo demo = ac.getBean("demo", Demo.class);
        System.out.println("demo.demo1()");
        try {
            demo.demo1();
        } catch (Exception exception) {
        }
        System.out.println("demo.demo2()");
        try {
            demo.demo2();
        } catch (Exception exception) {
        }
        System.out.println("demo.demo3()");
        demo.demo3();
    }
}
