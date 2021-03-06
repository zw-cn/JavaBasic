package com.zw.spring.pojo.fruit;

/**
 * <p>Title: JavaBasic-com.zw.spring.pojo</p>
 * <p>Description: 实例水果工厂</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
public class FruitFactory {
    Fruit newInstance(String name){
        switch (name){
            case "apple":return new Apple();
            case "banana":return new Banana();
            default:return null;
        }
    }
}
