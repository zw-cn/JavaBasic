package com.zw.patten;

/**
 * @program: JavaBasic
 * @description: 单例模式-饿汉式实现
 * 1.线程安全
 * 2.效率高
 * 3.不能延时加载
 * @author: zw-cn
 * @create: 2020-02-26 22:48
 */
public class Patten_01_Single_01_Hungry {
    private static Patten_01_Single_01_Hungry instance = new Patten_01_Single_01_Hungry();
    private Patten_01_Single_01_Hungry(){

    }
    public static Patten_01_Single_01_Hungry getInstance(){
        return instance;
    }
}
class Patten_01_Single_01_HungryTest{
    public static void main(String[] args) {
        Patten_01_Single_01_Hungry single = Patten_01_Single_01_Hungry.getInstance();
        System.out.println(single.hashCode());
    }
}