package com.zw.spring.pojo.fruit;

/**
 * <p>Title: JavaBasic-com.zw.spring.pojo</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class Fruit{
    protected String name;
    protected String color;

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
