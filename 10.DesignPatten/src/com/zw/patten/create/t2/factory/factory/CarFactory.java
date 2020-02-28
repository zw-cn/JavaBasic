package com.zw.patten.create.t2.factory.factory;

import com.zw.patten.create.t2.factory.Audi;
import com.zw.patten.create.t2.factory.Byd;
import com.zw.patten.create.t2.factory.Car;
import com.zw.patten.create.t2.factory.Tesla;

/**
 * @program: JavaBasic
 * @description: 汽车工厂接口
 * @author: zw-cn
 * @create: 2020-02-28 12:36
 */
public interface CarFactory {
    Car createCar();
}
class AudiFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Audi();
    }
}
class BydFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Byd();
    }
}
class TeslaFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Tesla();
    }
}

