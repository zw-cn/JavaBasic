package com.zw.patten.create.singleton;

/**
 * @program: JavaBasic
 * @description: 单例模式-枚举类实现
 * 由JVM提供单例的保证，而且无需担心反射和反序列化漏洞
 * @author: zw-cn
 * @create: 2020-02-27 17:18
 */
public enum Patten_01_Single_05_Enum {
    INSTANCE;
    public void otherMethod(){
        System.out.println("You can add methods you need");
    }
}
class Patten_01_Single_05_EnumTest{
    public static void main(String[] args) {
        Patten_01_Single_05_Enum en1 = Patten_01_Single_05_Enum.INSTANCE;
        Patten_01_Single_05_Enum en2 = Patten_01_Single_05_Enum.INSTANCE;
        en1.otherMethod();
        System.out.println(en1 == en2);
    }
}
