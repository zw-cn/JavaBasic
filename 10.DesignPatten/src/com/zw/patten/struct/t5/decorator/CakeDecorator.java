package com.zw.patten.struct.t5.decorator;

/**
 * @program: JavaBasic
 * @description: 蛋糕与装饰模式
 * @author: zw-cn
 * @create: 2020-03-04 21:54
 */
public class CakeDecorator {
    public static void main(String[] args) {
        System.out.println("我的蛋糕");
        MyCake cake = new MyCake();
        ICake finalCake = new Peanut(new Strawberry(new Peach(new Cream(cake))));
        finalCake.show();
    }
}
interface ICake{
    void show();
}
class MyCake implements ICake{
    @Override
    public void show() {
        System.out.println("蛋糕胚");
    }
}
class AddableCake implements ICake{
    protected ICake cake;

    public AddableCake(ICake cake) {
        this.cake = cake;
    }

    @Override
    public void show() {
        cake.show();
    }
}
class Coffee extends AddableCake{

    public Coffee(ICake cake) {
        super(cake);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("+咖啡酱");
    }
}
class Peanut extends AddableCake{

    public Peanut(ICake cake) {
        super(cake);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("+花生酱");
    }
}
class Strawberry extends AddableCake{

    public Strawberry(ICake cake) {
        super(cake);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("+草莓酱");
    }
}
class Cream extends AddableCake{

    public Cream(ICake cake) {
        super(cake);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("+奶油酱");
    }
}
class Peach extends AddableCake{

    public Peach(ICake cake) {
        super(cake);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("+桃子片");
    }
}