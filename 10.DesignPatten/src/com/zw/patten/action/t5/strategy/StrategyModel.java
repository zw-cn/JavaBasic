package com.zw.patten.action.t5.strategy;

/**
 * @program: JavaBasic
 * @description: 策略模式
 * @author: zw-cn
 * @create: 2020-03-06 14:33
 */
public class StrategyModel {
    public static void main(String[] args) {
        Strategy strategy = new OldCustomLittlePrice();
        new Context(strategy).settle(666);
    }
}
class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void settle(double price){
        System.out.println("total is :"+strategy.getPrice(price));
    }
}
interface Strategy{
    double getPrice(double fullPrice);
}
class OldCustomManyPrice implements Strategy{
    @Override
    public double getPrice(double fullPrice) {
        return fullPrice*0.7;
    }
}
class NewCustomManyPrice implements Strategy{
    @Override
    public double getPrice(double fullPrice) {
        return fullPrice*0.9;
    }
}
class NewCustomLittlePrice implements Strategy{
    @Override
    public double getPrice(double fullPrice) {
        return fullPrice;
    }
}
class OldCustomLittlePrice implements Strategy{
    @Override
    public double getPrice(double fullPrice) {
        return fullPrice*0.8;
    }
}
