package com.zw.patten.create.t2.factory.abstractFactory.product.impl;

import com.zw.patten.create.t2.factory.abstractFactory.product.Seat;

/**
 * @program: JavaBasic
 * @description:
 * @author: zw-cn
 * @create: 2020-02-28 13:46
 */
public class CommonSeat implements Seat {
    @Override
    public String feel() {
        return "feeling sick!";
    }
}
