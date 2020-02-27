package com.zw.patten;

/**
 * @program: JavaBasic
 * @description: 单例模式-饱汉式实现
 * @author: zw-cn
 * @create: 2020-02-26 22:55
 */
public class Patten_01_Single_02_Full {
    private static Patten_01_Single_02_Full single;
    public static synchronized Patten_01_Single_02_Full getInstance(){
        if(single == null){
            single = new Patten_01_Single_02_Full();
        }
        return single;
    }
}
class Patten_01_Single_02_FullTest{
    public static void main(String[] args) {
        Patten_01_Single_02_Full single = Patten_01_Single_02_Full.getInstance();
        System.out.println(single.hashCode());
    }
}
