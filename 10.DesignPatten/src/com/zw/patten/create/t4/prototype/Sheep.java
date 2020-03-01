package com.zw.patten.create.t4.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: JavaBasic
 * @description: 克隆羊
 * 浅克隆
 * @author: zw-cn
 * @create: 2020-03-01 13:31
 */
public class Sheep implements Cloneable, Serializable {
    private String name;
    private Date birthday;

    public Sheep() {
        try {
            Thread.sleep(10);//模拟生成一个对象的耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
