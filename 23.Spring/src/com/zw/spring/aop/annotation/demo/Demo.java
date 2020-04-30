package com.zw.spring.aop.annotation.demo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.annotation.demo</p>
 * <p>Description: 测试切点类</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/30/2020
 */
@Component
public class Demo {
    @Pointcut("execution(* com.zw.spring.aop.annotation.demo.Demo.demo1())")
    public void demo1(){
        System.out.println("Demo.demo1");
        //System.out.println(1/0);
    }
    @Pointcut("execution(* com.zw.spring.aop.annotation.demo.Demo.demo2())")
    public void demo2(){
        System.out.println("Demo.demo2");
        System.out.println(1/0);
    }
    @Pointcut("execution(* com.zw.spring.aop.annotation.demo.Demo.demo3())")
    public void demo3(){
        System.out.println("Demo.demo3");
    }
}
