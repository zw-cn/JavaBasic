package com.zw.patten.struct.t7.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 享元模式
 * @author: zw-cn
 * @create: 2020-03-05 11:06
 */
public class FlyweightModel {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f1 =factory.getFlyweight("A");
        Flyweight f2 =factory.getFlyweight("A");
        System.out.println(f1);
        System.out.println(f2);
        f1.operation(new UnsharedConcreteFlyweight(1,1));
        f2.operation(new UnsharedConcreteFlyweight(2,2));
    }
}
/**
 * @description: 享元工厂类
 * 负责创建并管理享元对象，享元池一般设计成键值对
 * @author: zw-cn
 * @create: 3/5/2020 2:36 PM
 */
class FlyweightFactory{
    private Map<String,ConcreteFlyweight> map = new HashMap<>();
    public ConcreteFlyweight getFlyweight(String inner){
        ConcreteFlyweight c = null;
        if ((c = map.get(inner)) == null) {
            c = new ConcreteFlyweight(inner);
            map.put(inner, c);
        }
        return c;
    }

}
/**
 * @description: 抽象享元类
 * 通常是一个接口或抽象类，声明公共方法，这些方法可以向外界提供对象的内部状态和设置外部状态
 * @author: zw-cn
 * @create: 3/5/2020 2:37 PM
 */
interface Flyweight{
    void operation(UnsharedConcreteFlyweight position);
}
/**
 * @description: 具体享元类
 * 为内部状态提供成员变量进行存储
 * @author: zw-cn
 * @create: 3/5/2020 2:39 PM
 */
class ConcreteFlyweight implements Flyweight{
    private String inner;

    public ConcreteFlyweight(String inner) {
        this.inner = inner;
    }

    @Override
    public void operation(UnsharedConcreteFlyweight position) {
        System.out.println("inner->"+inner+"@"+position.getX()+","+position.getY());
    }
}
/**
 * @description: 不能被共享的子类可以设计为非共享享元类
 * @author: zw-cn
 * @create: 3/5/2020 2:40 PM
 */
class UnsharedConcreteFlyweight{
    private int x,y;

    public UnsharedConcreteFlyweight(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}