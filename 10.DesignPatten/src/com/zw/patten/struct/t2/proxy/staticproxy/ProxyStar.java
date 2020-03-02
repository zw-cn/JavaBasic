package com.zw.patten.struct.t2.proxy.staticproxy;

/**
 * @program: JavaBasic
 * @description: 明星经纪人
 * @author: zw-cn
 * @create: 2020-03-02 11:57
 */
public class ProxyStar implements Star {
    Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract");
    }

    @Override
    public void sellTicket() {
        System.out.println("ProxyStar.sellTicket");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void getMoney() {
        System.out.println("ProxyStar.getMoney");
    }
}
