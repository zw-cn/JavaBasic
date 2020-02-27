package com.zw.patten;

/**
 * @program: JavaBasic
 * @description: 单例模式-静态内部类实现
 * 线程安全、效率高、可延时加载，强于饿汉式实现
 * @author: zw-cn
 * @create: 2020-02-27 17:04
 */
public class Patten_01_Single_04_StaticInnerClass {
    private Patten_01_Single_04_StaticInnerClass(){
    }
    static class Patten_01_Single_04_StaticInnerClass_Inner{
        private static Patten_01_Single_04_StaticInnerClass instance = new Patten_01_Single_04_StaticInnerClass();
    }
    public static Patten_01_Single_04_StaticInnerClass getInstance(){
        return Patten_01_Single_04_StaticInnerClass_Inner.instance;
    }
}
class Patten_01_Single_04_StaticInnerClassTest{
    public static void main(String[] args) {
        Patten_01_Single_04_StaticInnerClass instance1 = Patten_01_Single_04_StaticInnerClass.getInstance();
        Patten_01_Single_04_StaticInnerClass instance2 = Patten_01_Single_04_StaticInnerClass.getInstance();
        System.out.println(instance1 == instance2);
    }
}
