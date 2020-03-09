package com.zw.patten.action.t9.state;

/**
 * @program: JavaBasic
 * @description: 状态模式
 * @author: zw-cn
 * @create: 2020-03-06 16:54
 */
public class StateModel {
    public static void main(String[] args) {
        System.out.println("售货机");
        AutoSeller seller = new AutoSeller();
        seller.buy();
        System.out.println("*************************");
        System.out.println("酒店公寓");
        Context context = new Context();
        context.setState(new Empty());
        context.setState(new Occupy());
    }
}

interface State {
    void putMoney();

    void choseProduct();

    void sell();

    void change();
}

class WaitState implements State {
    private AutoSeller autoSeller;

    public WaitState(AutoSeller autoSeller) {
        this.autoSeller = autoSeller;
    }

    @Override
    public void putMoney() {
        System.out.println("欢迎使用无人售货机！");
        autoSeller.setCurrentState(autoSeller.ReadyState);
    }

    @Override
    public void choseProduct() {
        System.out.println("欢迎使用无人售货机！");
    }

    @Override
    public void sell() {
        System.out.println("请投币！");
    }

    @Override
    public void change() {
        System.out.println("请投币！");
    }
}

class ReadyState implements State {
    private AutoSeller autoSeller;

    public ReadyState(AutoSeller autoSeller) {
        this.autoSeller = autoSeller;
    }

    @Override
    public void putMoney() {
        System.out.println("请选择商品");
    }

    @Override
    public void choseProduct() {
        System.out.println("已选择商品");
        autoSeller.setCurrentState(autoSeller.SellState);
    }

    @Override
    public void sell() {
        System.out.println("请选择商品");
    }

    @Override
    public void change() {
        System.out.println("请选择商品");
    }
}

class SellState implements State {
    private AutoSeller autoSeller;

    public SellState(AutoSeller autoSeller) {
        this.autoSeller = autoSeller;
    }

    @Override
    public void putMoney() {
        System.out.println("出售中。。。");
    }

    @Override
    public void choseProduct() {
        System.out.println("出售中。。。");
    }

    @Override
    public void sell() {
        System.out.println("出售中。。。");
        autoSeller.setCurrentState(autoSeller.ChangeState);
    }

    @Override
    public void change() {
        System.out.println("出售中。。。");
    }
}

class ChangeState implements State {
    private AutoSeller autoSeller;

    public ChangeState(AutoSeller autoSeller) {
        this.autoSeller = autoSeller;
    }

    @Override
    public void putMoney() {
        System.out.println("谢谢惠顾");
    }

    @Override
    public void choseProduct() {
        System.out.println("谢谢惠顾");
    }

    @Override
    public void sell() {
        System.out.println("谢谢惠顾");
    }

    @Override
    public void change() {
        System.out.println("请收好找零");
    }
}

class AutoSeller {
    State WaitState;
    State ReadyState;
    State SellState;
    State ChangeState;
    private State currentState;

    public AutoSeller() {
        WaitState = new WaitState(this);
        ReadyState = new ReadyState(this);
        SellState = new SellState(this);
        ChangeState = new ChangeState(this);
        currentState = WaitState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void buy(){
        currentState.putMoney();
        currentState.choseProduct();
        currentState.sell();
        currentState.change();
    }
}

interface State2{
    void handle();
}
class Empty implements State2{
    @Override
    public void handle() {
        System.out.println("可以使用");
    }
}
class Occupy implements State2{
    @Override
    public void handle() {
        System.out.println("已被使用");
    }
}
class Order implements State2{
    @Override
    public void handle() {
        System.out.println("已预订");
    }
}
class Context{
    private State2 state;
    public void setState(State2 state){
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}