package com.zw.patten.struct.t2.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>Title: JavaBasic-com.zw.patten.struct.t2.proxy.dynamicproxy.cglib</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/30/2020
 */
public class StarProxy implements MethodInterceptor {
    public void ProxyConfer() {
        System.out.println("经纪人洽谈去了");
    }

    /**
     *
     * obj - "this", the enhanced object
     * method - intercepted Method
     * args - argument array; primitive types are wrapped
     * proxy - used to invoke super (non-intercepted method); may be called as many times as needed
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        ProxyConfer();
        System.out.println(method.getName());
        methodProxy.invokeSuper(o,objects);
        return null;
    }
}
