package com.zw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: JavaBasic
 * @description: 使用反射机制
 * @author: zw-cn
 * @create: 2020-02-19 15:44
 */
public class Reflection_02 {
    public static void main(String[] args) throws Exception {
        Class<User> clazz = null;
        try {
            clazz = (Class<User>) Class.forName("com.zw.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //调用无参数构造器
        User u1 = clazz.getConstructor().newInstance();
        System.out.println(u1);
        Constructor<User> c1 = clazz.getConstructor(String.class, int.class);
        User u2 = c1.newInstance("张三",100);
        System.out.println(u2);

        //调用普通方法
        Method m1 = clazz.getDeclaredMethod("setName",String.class);
        m1.invoke(u2,"李四");
        System.out.println(u2.getName());

        //修改属性
        Field f1 = clazz.getDeclaredField("age");
        f1.setAccessible(true);//设置成可访问的
        f1.set(u2,18);
        System.out.println(f1.get(u2));//通过反射读属性值
        System.out.println(u2.getAge());
    }
}
