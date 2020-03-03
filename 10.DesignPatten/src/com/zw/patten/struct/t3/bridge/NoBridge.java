package com.zw.patten.struct.t3.bridge;

/**
 * @program: JavaBasic
 * @description: 不使用桥接模式的多层继承
 * @author: zw-cn
 * @create: 2020-03-03 11:03
 */
public class NoBridge {
    public static void main(String[] args) {
        Computer c = new LenovoPad();
        c.compute();
    }
}
interface Computer{
    void compute();
}
class PC implements Computer{
    @Override
    public void compute() {

    }
}
class Pad implements Computer{
    @Override
    public void compute() {

    }
}
class Laptop implements Computer{
    @Override
    public void compute() {

    }
}

class LenovoPC extends PC{
    @Override
    public void compute() {
        System.out.println("LenovoPC.compute");
    }
}
class LenovoPad extends Pad{
    @Override
    public void compute() {
        System.out.println("LenovoPad.compute");
    }
}
class LenovoLaptop extends Laptop{
    @Override
    public void compute() {
        System.out.println("LenovoLaptop.compute");
    }
}
class DellPC extends PC{
    @Override
    public void compute() {
        System.out.println("DellPC.compute");
    }
}
class DellPad extends Pad{
    @Override
    public void compute() {
        System.out.println("DellPad.compute");
    }
}
class DellLaptop extends Laptop{
    @Override
    public void compute() {
        System.out.println("DellLaptop.compute");
    }
}