package com.zw.patten.create.t2.factory.abstractFactory.product.impl;

import com.zw.patten.create.t2.factory.abstractFactory.product.Tyre;

/**
 * @program: JavaBasic
 * @description:
 * @author: zw-cn
 * @create: 2020-02-28 13:46
 */
public class SuperTyre implements Tyre {
    @Override
    public String durable() {
        return "Long lifetime";
    }
}
