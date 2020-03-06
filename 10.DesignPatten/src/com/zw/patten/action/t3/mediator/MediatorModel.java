package com.zw.patten.action.t3.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 中介者模式
 * @author: zw-cn
 * @create: 2020-03-06 10:04
 */
public class MediatorModel {
    public static void main(String[] args) {
        Mediator m = new President();
        Department finance = new Finance(m);
        Department market = new Market(m);
        Department develop = new Development(m);

        finance.selfAction();
        develop.selfAction();
        develop.outerAction();
    }



}
interface Mediator{
    void register(String part, Department department);
    void command(String s);
}
class President implements Mediator{
    private Map<String,Department> map = new HashMap<>();
    @Override
    public void register(String part, Department department) {
        map.put(part,department);
    }

    @Override
    public void command(String s) {
        map.get(s).outerAction();
    }
}
interface Department{
    void selfAction();
    void outerAction();
}
/**
 * @description: 研发部门
 * @author: zw-cn
 * @create: 3/6/2020 10:32 AM
 */
class Development implements Department{
    private Mediator mediator = null;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("develop",this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发");
    }

    @Override
    public void outerAction() {
        System.out.println("需要资金！");
        mediator.command("finance");
    }
}
/**
 * @description: 市场部门
 * @author: zw-cn
 * @create: 3/6/2020 10:32 AM
 */
class Market implements Department{
    private Mediator mediator = null;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("谈客户！");
    }

    @Override
    public void outerAction() {
        System.out.println("拿到钱了！");
    }
}
/**
 * @description: 财务部门
 * @author: zw-cn
 * @create: 3/6/2020 10:32 AM
 */
class Finance implements Department{
    private Mediator mediator = null;

    public Finance(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register("finance",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱！");
    }

    @Override
    public void outerAction() {
        mediator.command("market");
    }
}