package com.zw.patten.create.t2.factory.simplefactory;

import com.zw.patten.create.t2.factory.Audi;
import com.zw.patten.create.t2.factory.Byd;
import com.zw.patten.create.t2.factory.Car;

/**
 * @program: JavaBasic
 * @description: 简单工厂模式
 * 违反开闭原则
 * @author: zw-cn
 * @create: 2020-02-28 11:53
 */
public class SimpleFactory {
    public static Car getCar(String name){
        if ("Audi".equals(name)){
            return new Audi();
        }
        if ("Byd".equals(name)){
            return new Byd();
        }
        return null;
    }
}
class SimpleFactoryTest{
    public static void main(String[] args) {
        Car c = SimpleFactory.getCar("Byd");
        c.run();
    }
}
