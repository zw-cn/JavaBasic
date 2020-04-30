package com.zw.patten.struct.t2.proxy.dynamicproxy.jdk;

/**
 * @program: JavaBasic
 * @description: 周杰伦
 * @author: zw-cn
 * @create: 2020-03-02 11:55
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract");
    }

    @Override
    public void sellTicket() {
        System.out.println("RealStar.sellTicket");
    }

    @Override
    public void sing() {
        System.out.println("RealStar(周杰伦).sing");
    }

    @Override
    public void getMoney() {
        System.out.println("RealStar.getMoney");
    }
}
