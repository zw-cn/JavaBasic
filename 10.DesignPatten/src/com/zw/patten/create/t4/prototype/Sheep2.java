package com.zw.patten.create.t4.prototype;

import java.util.Date;

/**
 * @program: JavaBasic
 * @description: 克隆羊
 * 深克隆
 * @author: zw-cn
 * @create: 2020-03-01 13:31
 */
public class Sheep2 implements Cloneable {
    private String name;
    private Date birthday;

    public Sheep2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        Sheep2 sheep = (Sheep2) o;
        sheep.birthday = (Date) this.birthday.clone();
        return o;
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
