package com.zw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: JavaBasic
 * @description: 反射基本操作
 * @author: zw-cn
 * @create: 2020-02-19 13:44
 */
public class Reflection_01 {
    public static void main(String[] args) throws Exception {
        Class uClazz = null;
        //获取类
        {
            try {
                uClazz = Class.forName("com.zw.reflection.User");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //获取类信息
            System.out.println(uClazz.getName());
            System.out.println(uClazz.getSimpleName());
        }

        //获取构造器
        {
            //公开的构造器
            Constructor c1 = uClazz.getConstructor(null);//获取空构造器
            Constructor c2 = uClazz.getConstructor(String.class, int.class);//获取有参构造器
            Constructor[] cAll = uClazz.getConstructors();
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(cAll.length);
            //声明的构造器
            Constructor cd1 = uClazz.getDeclaredConstructor(null);//获取空构造器
            Constructor cd2 = uClazz.getDeclaredConstructor(String.class);//获取有参构造器
            Constructor[] cdAll = uClazz.getDeclaredConstructors();
            System.out.println(cd1);
            System.out.println(cd2);
            System.out.println(cdAll.length);
        }

        //获取属性
        {
            Field f1 = uClazz.getField("title");
            Field[] fAll = uClazz.getFields();
            Field fd1 = uClazz.getDeclaredField("name");
            Field[] fdAll = uClazz.getDeclaredFields();
        }

        //获取方法
        {
            //公开的
            Method m1 = uClazz.getMethod("setName");
            Method m2 = uClazz.getMethod("setName",String.class);
            //私有的
            Method md1 = uClazz.getDeclaredMethod("setAge");
            Method md2 = uClazz.getDeclaredMethod("setAge",int.class);
            Method[] mdAll = uClazz.getDeclaredMethods();
        }

    }
}
class User{
    public String title;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private User(String name) {
        this.name = name;
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName() {
        this.name = "";
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
    private void setAge() {
        this.age = 0;
    }
}
