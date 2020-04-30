package com.zw.spring.aop.test;

import com.zw.spring.aop.ServiceStep;
import com.zw.spring.aop.aspectj.service.MyAspectJService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/zw/spring/aop/xml/ApplicationContext.xml");
        ServiceStep service = ac.getBean("service", ServiceStep.class);
        service.step1();
        service.step2();
        service.step3();

        MyAspectJService aspSer = ac.getBean("aspSer", MyAspectJService.class);
        aspSer.doSomething();
    }
}
