package com.zw.spring.aop.schema.service;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.schema.service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class DemoS {
    public void demoThrow(){
        System.out.println("DemoS.demo");
        System.out.println(1/0);
    }
    public void demoAround(){
        System.out.println("DemoS.demoAround");
    }
}
