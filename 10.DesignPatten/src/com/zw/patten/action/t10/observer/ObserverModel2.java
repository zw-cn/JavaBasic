package com.zw.patten.action.t10.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: JavaBasic
 * @description: 观察者模式-JDK实现
 * @author: zw-cn
 * @create: 2020-03-09 09:57
 */
public class ObserverModel2 {
    public static void main(String[] args) {
        ConcreteSubject2 subject2 = new ConcreteSubject2();
        ConcreteObserver2 observer1 = new ConcreteObserver2();
        ConcreteObserver2 observer2 = new ConcreteObserver2();
        ConcreteObserver2 observer3 = new ConcreteObserver2();

        subject2.addObserver(observer1);
        subject2.addObserver(observer2);
        subject2.addObserver(observer3);

        subject2.setState(300);

        System.out.println(observer1.getMyState());
        System.out.println(observer2.getMyState());
        System.out.println(observer3.getMyState());
    }
}
class ConcreteSubject2 extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }
}
class ConcreteObserver2 implements Observer{
    private int myState;


    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject2)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}