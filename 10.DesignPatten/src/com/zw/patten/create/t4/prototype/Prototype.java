package com.zw.patten.create.t4.prototype;

import java.io.*;
import java.util.Date;

/**
 * @program: JavaBasic
 * @description: 原型模式
 * 若创建对象的时间比较长，可以采用原型模式
 * @author: zw-cn
 * @create: 2020-03-01 13:29
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        {
            Date birthday = new Date(11111111111L);
            Sheep sheep = new Sheep("真多莉", birthday);
            Sheep cloneSheep = (Sheep) sheep.clone();
            cloneSheep.setName("克隆多莉");
            System.out.println(sheep);
            System.out.println(cloneSheep);
            //浅克隆 Date成员依旧指向同一个Date对象
            birthday.setTime(2222222222L);
            System.out.println(sheep);
            System.out.println(cloneSheep);

            System.out.println("--------使用序列化和反序列化实现深克隆--------");
            Sheep newSheep = serializeDeepCopy(sheep);
            birthday.setTime(3333333333333L);
            System.out.println("sheep->"+sheep);
            System.out.println("newSheep->"+newSheep);
        }

        System.out.println("##############################");

        {
            Date birthday = new Date(11111111111L);
            Sheep2 sheep = new Sheep2("真多莉", birthday);
            Sheep2 cloneSheep = (Sheep2) sheep.clone();
            cloneSheep.setName("克隆多莉");
            System.out.println(sheep);
            System.out.println(cloneSheep);
            //深克隆 Date成员指向不同的Date对象,互不影响
            birthday.setTime(2222222222L);
            System.out.println(sheep);
            System.out.println(cloneSheep);
        }


        System.out.println("使用原型模式和不使用原型模式的比较：");
        noPrototype(1000);
        prototype(1000);
    }

    public static Sheep serializeDeepCopy(Sheep sheep) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Sheep newSheep = null;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(sheep);
            byte[] sheepByte = bos.toByteArray();

            ByteArrayInputStream bis = new ByteArrayInputStream(sheepByte);
            ObjectInputStream ois = new ObjectInputStream(bis);
            newSheep = (Sheep) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newSheep;
    }

    public static void noPrototype(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Sheep s = new Sheep();
        }
        long end = System.currentTimeMillis();
        System.out.println("不使用原型模式耗时：" + (end - start));
    }

    public static void prototype(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Sheep s = new Sheep();
        for (int i = 0; i < size; i++) {
            Sheep n = (Sheep) s.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用原型模式耗时：" + (end - start));
    }
}
