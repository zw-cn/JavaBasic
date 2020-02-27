package com.zw.patten;

import java.lang.reflect.Constructor;

/**
 * @program: JavaBasic
 * @description: 单例模式-反射和反序列化破解及反破解
 * @author: zw-cn
 * @create: 2020-02-27 17:44
 */
public class Patten_01_Single_06_Crack {
    private static Patten_01_Single_06_Crack instance = new Patten_01_Single_06_Crack();
    private Patten_01_Single_06_Crack(){

    }
    public static Patten_01_Single_06_Crack getInstance(){
        return instance;
    }
}
class Patten_01_Single_06_CrackTest{
    public static void main(String[] args) {
        Patten_01_Single_06_Crack s1 = Patten_01_Single_06_Crack.getInstance();
        Patten_01_Single_06_Crack s2 = Patten_01_Single_06_Crack.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        //通过反射破解
        {
            try {
                Class clazz = Class.forName("com.zw.patten.Patten_01_Single_06_Crack");
                Constructor c = clazz.getDeclaredConstructor();
                c.setAccessible(true);
                System.out.println(c.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
