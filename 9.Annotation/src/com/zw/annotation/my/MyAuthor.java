package com.zw.annotation.my;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: JavaBasic
 * @description: JavaAssist注解
 * @author: zw-cn
 * @create: 2020-02-23 11:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAuthor {
    String name();
    int year();
}
