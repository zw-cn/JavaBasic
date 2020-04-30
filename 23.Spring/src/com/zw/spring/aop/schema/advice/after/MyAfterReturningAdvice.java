package com.zw.spring.aop.schema.advice.after;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.schema.advice.after</p>
 * <p>Description: 后置通知</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("MyAfterReturningAdvice.afterReturning:后置通知");
    }
}
