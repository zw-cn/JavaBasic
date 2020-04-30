package com.zw.spring.aop.schema.advice.thr;

import org.springframework.aop.ThrowsAdvice;

/**
 * <p>Title: JavaBasic-com.zw.spring.aop.schema.advice.thr</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class DemoSThrow implements ThrowsAdvice {
    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("schema-based:"+ex.getMessage());
    }
}
