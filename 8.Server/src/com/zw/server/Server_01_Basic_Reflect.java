package com.zw.server;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: JavaBasic
 * @description: 获取对象class的3种方式
 * @author: zw-cn
 * @create: 2020-02-12 16:48
 */
public class Server_01_Basic_Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取类的3种方式
        //方法1： 根据对象获取类
        Apple apple1 = new Apple();
        Class clazz = apple1.getClass();
        //方法2： 根据类名获取
        clazz = Apple.class;
        //方法3： 通过反射获取
        clazz = Class.forName("com.zw.server.Apple");

        //根据类动态创建对象
        //方式1:
        Apple apple2 = (Apple) clazz.newInstance();//JDK9以后过时
        //方式2:
        apple2 = (Apple)clazz.getConstructor().newInstance();
    }
}
class Apple{
    public Apple() {
    }
}
