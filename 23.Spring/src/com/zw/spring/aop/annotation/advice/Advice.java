package com.zw.spring.aop.annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.annotation.advice</p>
 * <p>Description: 通知类</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/30/2020
 */
@Component
@Aspect
public class Advice {
    @Before("com.zw.spring.aop.annotation.demo.Demo.demo1()")
    public void before(){
        System.out.println("前置通知");
    }
    @After("com.zw.spring.aop.annotation.demo.Demo.demo1()")
    public void after(){
        System.out.println("后置通知");
    }
    @AfterReturning("com.zw.spring.aop.annotation.demo.Demo.demo1()")
    public void afterReturning(){
        System.out.println("后置通知2:只有正常返回才执行，切点异常不执行此后置通知");
    }
    @AfterThrowing("com.zw.spring.aop.annotation.demo.Demo.demo2()")
    public void throwing(){
        System.out.println("异常通知");
    }
    @Around("com.zw.spring.aop.annotation.demo.Demo.demo3()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知");
        System.out.println("环绕前置");
        Object result = point.proceed();
        System.out.println("环绕后置");
        return result;
    }

}
