package com.zw.patten.create.t2.factory.abstractFactory.product.impl;

import com.zw.patten.create.t2.factory.abstractFactory.product.Engine;

/**
 * @program: JavaBasic
 * @description:
 * @author: zw-cn
 * @create: 2020-02-28 13:46
 */
public class PoorEngine implements Engine {
    @Override
    public String sound() {
        return "哒哒哒";
    }
}
