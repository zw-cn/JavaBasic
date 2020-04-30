package com.zw.patten.struct.t2.proxy.dynamicproxy.jdk;

/**
 * @program: JavaBasic
 * @description: 分析自动生成的动态代理类
 * 持有StarHandler，并调用其invoke方法
 * @author: zw-cn
 * @create: 2020-03-02 15:04
 */
public class ProxyHandler implements Star {
    StarHandler handler;
    @Override
    public void confer() {
        //handler.invoke(this,调用的方法,参数);
    }

    @Override
    public void signContract() {
        //handler.invoke(this,调用的方法,参数);
    }

    @Override
    public void sellTicket() {
        //handler.invoke(this,调用的方法,参数);
    }

    @Override
    public void sing() {
        //handler.invoke(this,调用的方法,参数);
    }

    @Override
    public void getMoney() {
        //handler.invoke(this,调用的方法,参数);
    }
}
