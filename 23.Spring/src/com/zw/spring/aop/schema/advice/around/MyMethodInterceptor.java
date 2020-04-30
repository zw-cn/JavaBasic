package com.zw.spring.aop.schema.advice.around;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.schema.advice.around</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MyMethodInterceptor.invoke:前置通知");
        methodInvocation.proceed();
        System.out.println("MyMethodInterceptor.invoke:后置通知");
        return null;
    }
}
