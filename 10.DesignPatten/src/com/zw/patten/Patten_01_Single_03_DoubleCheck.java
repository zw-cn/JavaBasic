package com.zw.patten;

/**
 * @program: JavaBasic
 * @description: 单例模式-双重检测锁实现
 * @author: zw-cn
 * @create: 2020-02-27 16:42
 */
public class Patten_01_Single_03_DoubleCheck {
    private volatile static Patten_01_Single_03_DoubleCheck instance;//注意要添加volatile关键字
    private Patten_01_Single_03_DoubleCheck(){

    }
    /**
     * @description: 双重检查加锁不适用于1.4之前
     * @param
     * @return: com.zw.patten.Patten_01_Single_03_DoubleCheck
     * @author: zw-cn
     * @time: 2/27/2020 4:57 PM
     */
    public static Patten_01_Single_03_DoubleCheck getInstance(){
        if(instance == null){
            synchronized (Patten_01_Single_03_DoubleCheck.class){
                if(instance == null){
                    instance = new Patten_01_Single_03_DoubleCheck();
                }
            }
        }
        return instance;
    }
}

class Patten_01_Single_03_DoubleCheckTest{
    public static void main(String[] args) {
        Patten_01_Single_03_DoubleCheck s1 = Patten_01_Single_03_DoubleCheck.getInstance();
        Patten_01_Single_03_DoubleCheck s2 = Patten_01_Single_03_DoubleCheck.getInstance();
        System.out.println(s1 == s2);
    }
}
