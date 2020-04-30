package com.zw.patten.struct.t2.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

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
public class CGlibProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealStar.class);
        enhancer.setCallback(new StarProxy());
        RealStar starProxy = (RealStar) enhancer.create();
        starProxy.confer();
    }
}
