package com.zw.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaBasic
 * @description: 反射操作泛型
 * @author: zw-cn
 * @create: 2020-02-19 17:06
 */
public class Reflection_04_Type {
    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }
    public Map<Integer, User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m1 = Reflection_04_Type.class.getMethod("test01", Map.class, List.class);
        Type[] t1= m1.getGenericParameterTypes();//参数列表（可能多个）
        for (Type type : t1) {
            System.out.println("*"+type);
            if(type instanceof ParameterizedType){
                Type[] gType = ((ParameterizedType) type).getActualTypeArguments();//获取实际泛型
                for (Type type1 : gType) {
                    System.out.println(" ->"+type1);
                }
            }
        }

        System.out.println("------------------");

        Method m2 = Reflection_04_Type.class.getMethod("test02");
        Type t2 = m2.getGenericReturnType();//返回类型（只有一个）
        System.out.println(t2);
        if(t2 instanceof ParameterizedType){
            Type[] rType = ((ParameterizedType) t2).getActualTypeArguments();//获取实际泛型
            for (Type type : rType) {
                System.out.println("->"+type);
            }
        }
    }
}
