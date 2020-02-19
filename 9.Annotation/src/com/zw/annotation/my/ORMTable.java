package com.zw.annotation.my;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: JavaBasic
 * @description: 表注解：自定义注解
 * @author: zw-cn
 * @create: 2020-02-18 23:17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ORMTable {
    String value() default "";//表明
}
