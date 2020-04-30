package com.zw.spring.aop.aspectj.test;

import com.zw.spring.aop.aspectj.service.MyAspectJService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.aspectj.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zw/spring/aop/xml/ApplicationContext.xml");
        MyAspectJService aspSer = ac.getBean("aspSer", MyAspectJService.class);
        aspSer.beforeDoing();
        aspSer.afterDoing();
        aspSer.underDoing();
        try {
            aspSer.afterExceptionDoing();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            aspSer.exceptionDoing();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        aspSer.doingWithParam("张三",18);
    }
}
