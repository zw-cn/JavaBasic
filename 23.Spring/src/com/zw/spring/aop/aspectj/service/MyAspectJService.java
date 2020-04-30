package com.zw.spring.aop.aspectj.service;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.aspectj.service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class MyAspectJService {
    public void doSomething(){
        System.out.println(1/0);
    }
    public void beforeDoing(){
        System.out.println("MyAspectJService.beforeDoing");
    }
    public void afterDoing(){
        System.out.println("MyAspectJService.afterDoing");
    }
    public void afterExceptionDoing(){
        System.out.println("MyAspectJService.afterExceptionDoing");
    }
    public void underDoing(){
        System.out.println("MyAspectJService.underDoing");
    }
    public void exceptionDoing(){
        System.out.println(1/0);
        System.out.println("MyAspectJService.exceptionDoing");
    }
    public void doingWithParam(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
    }
}
