package com.zw.spring.aop.aspectj.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.aspectj.advice</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class MyAspectJ {
    public void before(){
        System.out.println("前置通知AspectJ");
    }
    public void after(){
        System.out.println("后置通知AspectJ");
    }
    public void afterReturning(){
        System.out.println("后置通知afterReturning-AspectJ");
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知AspectJ");
        System.out.println("环绕前置AspectJ");
        Object result = joinPoint.proceed();
        System.out.println("环绕后置AspectJ");
        return result;
    }
    public void throwing(){
        System.out.println("异常通知AspectJ");
    }
    public void beforeWithParam(String arg0,int arg1){
        System.out.println("MyAspectJ.beforeWithParam"+arg0+":"+arg1);
    }
}
