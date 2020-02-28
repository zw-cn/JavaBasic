package com.zw.patten.create.t2.factory.abstractFactory;

import com.zw.patten.create.t2.factory.abstractFactory.product.Engine;
import com.zw.patten.create.t2.factory.abstractFactory.product.Seat;
import com.zw.patten.create.t2.factory.abstractFactory.product.Tyre;
import com.zw.patten.create.t2.factory.abstractFactory.product.impl.*;
import com.zw.patten.create.t2.factory.abstractFactory.product.impl.*;

/**
 * @program: JavaBasic
 * @description: 汽车工厂
 * @author: zw-cn
 * @create: 2020-02-28 13:55
 */
public abstract class ComponentCar {
    Seat seat;
    Engine engine;
    Tyre tyre;
    AbstractCarComponentFactory factory;

    public abstract ComponentCar makeCar();

    void show(){
        System.out.println("Seat->"+seat.feel());
        System.out.println("Engine->"+engine.sound());
        System.out.println("Tyre->"+tyre.durable());
    }
}
class LuxuryCarStore extends ComponentCar{
    @Override
    public ComponentCar makeCar() {
        this.seat = new ComfortSeat();
        this.engine = new SuperEngine();
        this.tyre = new SuperTyre();
        return this;
    }
}
class CheepCarStore extends ComponentCar{
    @Override
    public ComponentCar makeCar() {
        this.seat = new CommonSeat();
        this.engine = new PoorEngine();
        this.tyre = new PoorTyre();
        return this;
    }
}
class ComponentCarTest{
    public static void main(String[] args) {
        ComponentCar c = new LuxuryCarStore().makeCar();
        ComponentCar c2 = new CheepCarStore().makeCar();
        c.show();
        c2.show();
    }
}
