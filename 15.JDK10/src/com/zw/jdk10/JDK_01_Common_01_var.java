package com.zw.jdk10;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: 局部变量类型推断</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_01_var {
    /**
     * <p>Description: 注意点:要求变量后有值，从而进行推断</br>
     * 1.只针对局部变量</br>
     * 2.var 是保留类型，不是关键字，这意味着我们还可以用var定义变量名或者是方法名
     * 3.var 不允许赋值为null
     * </p>
     *
     * @param args
     * @return void
     * @throws
     * @author zw-cn
     * @date: 3/25/2020 11:21 AM
     */
    public static void main(String[] args) {
        //var k ;//要求后面有值
        var i = 0;
        var str = "abc";
        var list = new ArrayList<String>();
        var set = new HashSet<String>();
        var map = new HashMap<Integer,String>();
        var user = new User();

        System.out.println(i);

        System.out.println(str);

        list.add("var1");
        System.out.println(list);

        set.add("var set");
        for (var s : set) {
            System.out.println(s);
        }

        map.put(18,"var map");
        for (var key : map.keySet()) {
            System.out.println(map.get(key));
        }

        user.setAge(99);
        user.setName("var User");
        System.out.println(user);

        /** 注意：Cannot infer type: variable initializer is 'null' */
        //var n = null;
    }
}
class User{
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
