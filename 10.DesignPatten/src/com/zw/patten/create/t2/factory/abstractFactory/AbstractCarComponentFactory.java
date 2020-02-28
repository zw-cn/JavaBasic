package com.zw.patten.create.t2.factory.abstractFactory;

import com.zw.patten.create.t2.factory.abstractFactory.product.Engine;
import com.zw.patten.create.t2.factory.abstractFactory.product.Seat;
import com.zw.patten.create.t2.factory.abstractFactory.product.Tyre;
import com.zw.patten.create.t2.factory.abstractFactory.product.impl.*;

/**
 * @program: JavaBasic
 * @description: 抽象汽车工厂
 * @author: zw-cn
 * @create: 2020-02-28 13:19
 */
public interface AbstractCarComponentFactory {
    Seat createSeat();
    Tyre createTyre();
    Engine createEngine();
}
class SuperCarComponentFactory implements AbstractCarComponentFactory {
    @Override
    public Seat createSeat() {
        return new ComfortSeat();
    }

    @Override
    public Tyre createTyre() {
        return new SuperTyre();
    }

    @Override
    public Engine createEngine() {
        return new SuperEngine();
    }
}
class CheapCarComponentFactory implements AbstractCarComponentFactory {
    @Override
    public Seat createSeat() {
        return new CommonSeat();
    }

    @Override
    public Tyre createTyre() {
        return new PoorTyre();
    }

    @Override
    public Engine createEngine() {
        return new PoorEngine();
    }
}