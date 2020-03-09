package com.zw.patten.action.t10.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 观察者模式
 * @author: zw-cn
 * @create: 2020-03-08 13:52
 */
public class ObserverModel {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteObserver observer3 = new ConcreteObserver();

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        ConcreteSubject s  = (ConcreteSubject)subject;
        s.setCount(199);

        System.out.println(observer1.getMyCount());
    }
}
interface Subject{

    void addObserver(Observer observer);
    void delObserver(Observer observer);
    void notifyAllObserver(Subject subject);
}
class ConcreteSubject implements Subject{
    protected List<Observer> list;
    private int count;

    public ConcreteSubject() {
        this.list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyAllObserver(Subject subject) {
        for (Observer observer : list) {
            observer.update(this);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyAllObserver(this);
    }
}
interface Observer{
    void update(Subject subject);
}
class ConcreteObserver implements Observer{
    private int myCount;

    @Override
    public void update(Subject subject) {
        this.myCount = ((ConcreteSubject)subject).getCount();
    }

    public int getMyCount() {
        return myCount;
    }

    public void setMyCount(int myCount) {
        this.myCount = myCount;
    }
}
