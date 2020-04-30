package com.zw.spring.aop.schema.test;

import com.zw.spring.aop.schema.service.DemoS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.schema.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class TestAOP4Schema {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zw/spring/aop/xml/ApplicationContext.xml");
        DemoS demoS = ac.getBean("demoS", DemoS.class);
        //demoS.demoThrow();
        System.out.println("-------------");
        demoS.demoAround();
    }
}
