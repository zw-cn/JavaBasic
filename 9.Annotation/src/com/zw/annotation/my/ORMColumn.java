package com.zw.annotation.my;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: JavaBasic
 * @description: 列注解
 * @author: zw-cn
 * @create: 2020-02-18 23:23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ORMColumn {
    String name();
    String type();
    int len();
}
