package com.zw.patten.action.t2.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 迭代器模式
 * @author: zw-cn
 * @create: 2020-03-05 17:07
 */
public class Iterator {
    public static void main(String[] args) {
        ConcreteMyAggregate c = new ConcreteMyAggregate();
        c.addObject("aa");
        c.addObject("bb");
        c.addObject("cc");

        MyIterator iterator = c.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getCurrent());
            iterator.next();
        }
    }
}

/**
 * @description: 自定义迭代器接口
 * @author: zw-cn
 * @create: 3/5/2020 5:10 PM
 */
interface MyIterator {
    void first();

    void last();

    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    Object getCurrent();
}

/**
 * @description: 自定义集合
 * @author: zw-cn
 * @create: 3/5/2020 5:11 PM
 */
class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public ConcreteMyAggregate() {
    }

    public void addObject(Object o) {
        list.add(o);
    }

    public void removeObject(Object o) {
        list.remove(o);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    /**
     * @param
     * @description: 获得迭代器
     * @return: com.zw.patten.action.t2.iterator.MyIterator
     * @author: zw-cn
     * @time: 3/5/2020 5:19 PM
     */
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements MyIterator {
        private int cursor;//用于记录游标的位置

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void last() {
            cursor = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            if (cursor < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size() - 1;
        }

        @Override
        public Object getCurrent() {
            return list.get(cursor);
        }

        @Override
        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }
    }
}
