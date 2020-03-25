package com.zw.sorm.core;

/**
 * @program: JavaBasic
 * @description: Query工厂类
 * 使用单例模式、原型模式
 * @author: zw-cn
 * @create: 2020-03-13 16:25
 */
public class QueryFactory {
    private static Query query;

    static {
        try {
            Class c = Class.forName(DBManager.getConf().getQueryClass());
            query = (Query) c.getConstructor().newInstance();
            //初始化
            System.out.println(DBManager.class);
            System.out.println(DBConnectionPool.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private QueryFactory() {
    }

    public static Query createQuery() {
        try {
            return (Query) query.clone();//使用原型模式，返回原型对象的拷贝，提高效率
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
