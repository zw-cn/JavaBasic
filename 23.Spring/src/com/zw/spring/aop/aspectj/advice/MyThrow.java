package com.zw.spring.aop.aspectj.advice;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.aspectj</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class MyThrow {
    public void deal(Exception exception){
        System.out.println("捕获切点异常信息:"+exception.getMessage());
    }
}
