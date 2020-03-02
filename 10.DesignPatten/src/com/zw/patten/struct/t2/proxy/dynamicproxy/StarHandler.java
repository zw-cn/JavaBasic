package com.zw.patten.struct.t2.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: JavaBasic
 * @description: 明星动态代理处理器
 * @author: zw-cn
 * @create: 2020-03-02 14:23
 */
public class StarHandler implements InvocationHandler {
    Star star;

    public StarHandler(Star star) {
        this.star = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if ("sing".equals(method.getName())){
            result = method.invoke(star,args);
        }
        return result;
    }
}
