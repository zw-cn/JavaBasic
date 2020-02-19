package com.zw.annotation.my;

/**
 * @program: JavaBasic
 * @description: 自定义注解
 * @author: zw-cn
 * @create: 2020-02-18 23:20
 */
public @interface MyAnnotation {
    String name() default "";
    String[] college() default {"家里蹲"};
    int age();
}
