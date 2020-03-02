package com.zw.patten.struct.t2.proxy.staticproxy;

/**
 * @program: JavaBasic
 * @description: 静态代理
 * @author: zw-cn
 * @create: 2020-03-02 11:59
 */
public class StaticProxy {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        ProxyStar proxy = new ProxyStar(realStar);
        proxy.confer();
        proxy.signContract();
        proxy.sellTicket();
        proxy.sing();
        proxy.getMoney();
    }
}
