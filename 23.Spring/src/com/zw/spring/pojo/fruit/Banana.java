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
public class Banana extends Fruit{
    public Banana() {
        this.name = "香蕉";
        this.color = "黄色";
    }
    public Banana(String color) {
        this();
        this.color = color;
    }
    public Banana(String name,String color) {
        this.name = name;
        this.color = color;
    }
}
