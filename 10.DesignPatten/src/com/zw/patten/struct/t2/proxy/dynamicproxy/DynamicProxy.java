package com.zw.patten.struct.t2.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @program: JavaBasic
 * @description: 动态代理：使用JDK实现
 * @author: zw-cn
 * @create: 2020-03-02 14:33
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Star star = new RealStar();
        StarHandler handler = new StarHandler(star);
        Star starProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handler);
        starProxy.sing();
    }
}
