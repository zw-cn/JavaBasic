package com.zw.patten.create.factory.nofactory;

import com.zw.patten.create.factory.Audi;
import com.zw.patten.create.factory.Car;

/**
 * @program: JavaBasic
 * @description: 无工厂模式
 * @author: zw-cn
 * @create: 2020-02-28 11:32
 */
public class NoFactory {
    public static void main(String[] args) {
        Car c = new Audi();//非依赖倒置
        c.run();
    }
}
