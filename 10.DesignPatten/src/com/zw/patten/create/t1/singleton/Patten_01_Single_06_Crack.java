package com.zw.patten.create.t1.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @program: JavaBasic
 * @description: 单例模式-反射和反序列化破解及反破解
 * @author: zw-cn
 * @create: 2020-02-27 17:44
 */
public class Patten_01_Single_06_Crack implements Serializable {
    private static Patten_01_Single_06_Crack instance;

    static {
        try {
            instance = new Patten_01_Single_06_Crack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Patten_01_Single_06_Crack() throws Exception {
        //反破解反射生成新对象
        {
            if(instance != null){
                throw new Exception("不允许再创建新对象！");
            }
        }
    }

    public static Patten_01_Single_06_Crack getInstance() {
        return instance;
    }

    /**
     * @description: 反序列化时，如果定义了readResolve方法，则直接返回此方法指定的对象，而不进行反序列化
     * @param 
     * @return: java.lang.Object
     * @author: zw-cn
     * @time: 2/28/2020 8:58 AM
     */
    private Object readResolve(){
        return instance;
    }
}

class Patten_01_Single_06_CrackTest {
    public static void main(String[] args) {
        Patten_01_Single_06_Crack s1 = Patten_01_Single_06_Crack.getInstance();
        Patten_01_Single_06_Crack s2 = Patten_01_Single_06_Crack.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        //通过反射破解
        {
            try {
                Class clazz = Class.forName("com.zw.patten.create.t1.singleton.Patten_01_Single_06_Crack");
                Constructor c = clazz.getDeclaredConstructor();
                c.setAccessible(true);
                System.out.println("通过反射破解了单例：" + c.newInstance());//Patten_01_Single_06_Crack的构造器防止反射破解单例模式
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //通过反序列化破解
        {
            //序列化
            {
                FileOutputStream fos;
                ObjectOutputStream oos;
                try {
//                    fos = new FileOutputStream(new File("./10.DesignPatten/doc/s1.obj").getAbsolutePath());
                    fos = new FileOutputStream("./10.DesignPatten/doc/s1.obj");
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(s1);
                    oos.flush();
                    oos.close();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //反序列化
            {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./10.DesignPatten/doc/s1.obj"));
                    Patten_01_Single_06_Crack ss1 = (Patten_01_Single_06_Crack) ois.readObject();
                    System.out.println("通过反射破解了单例："+ss1);//readResolve()方法防止反序列化破解单例
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
