package com.zw.spring;

import com.zw.spring.pojo.People;
import com.zw.spring.pojo.fruit.Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * <p>Title: JavaBasic-com.zw.spring</p>
 * <p>Description: 基本环境搭建</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class Basic {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zw/spring/xml/ApplicationContext.xml");
        basicOperation(applicationContext);
        diOperation(applicationContext);

    }


    /**
     * <p>Description: 基操勿6</p>
     *
     * @param applicationContext
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/28/2020 5:03 PM
     */
    private static void basicOperation(ApplicationContext applicationContext) {
        System.out.println("----------创建对象---------");
        System.out.println("默认方式创建对象");
        People people = applicationContext.getBean("peo", People.class);
        System.out.println(people);
        System.out.println("指定构造器方式创建对象");
        Fruit f1 = applicationContext.getBean("bnn", Fruit.class);
        System.out.println(f1);
        System.out.println("实例工厂方式创建对象");
        Fruit f2 = applicationContext.getBean("app", Fruit.class);
        System.out.println(f2);
        System.out.println("静态工厂方式创建对象");
        Fruit f3 = applicationContext.getBean("bnn2", Fruit.class);
        System.out.println(f3);
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

    /**
     * <p>Description: 设置对象属性和依赖注入</p>
     *
     * @param applicationContext
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/28/2020 5:30 PM
     */
    private static void diOperation(ApplicationContext applicationContext) {
        System.out.println("-------设置对象属性和依赖注入-------");
        People san = applicationContext.getBean("san", People.class);
        System.out.println(san);
    }
}
