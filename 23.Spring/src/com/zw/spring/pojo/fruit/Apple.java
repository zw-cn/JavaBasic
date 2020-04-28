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
class Apple extends Fruit{
    public Apple() {
        this.name = "苹果";
        this.color = "红色";
    }
    public Apple(String color) {
        this();
        this.color = color;
    }
}
