package com.zw.patten.create.t2.factory.factory;

import com.zw.patten.create.t2.factory.Car;

/**
 * @program: JavaBasic
 * @description: 工厂模式
 * @author: zw-cn
 * @create: 2020-02-28 12:36
 */
public class Factory {
    public static void main(String[] args) {
        Car c = new TeslaFactory().createCar();
        Car c2 = new AudiFactory().createCar();
        c.run();
        c2.run();
    }
}
