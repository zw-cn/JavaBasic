package com.zw.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaBasic
 * @description: 反射的性能比较
 * @author: zw-cn
 * @create: 2020-02-19 16:13
 */
public class Reflection_03_Performance {
    static final long TIMES=10*10000*10000;
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Test test = new Test();
        Reflection_03_Performance performance = new Reflection_03_Performance();
        performance.noReflection(test);
        performance.userReflection(test);
        performance.noCheckedReflection(test);
    }
    public void noReflection(Test test){
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            test.getName();
        }
        long end = System.currentTimeMillis();
        System.out.println("直接调用耗时："+(end-start));
    }
    public void userReflection(Test test) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = test.getClass().getDeclaredMethod("getName");
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            m.invoke(test);
        }
        long end = System.currentTimeMillis();
        System.out.println("检查的反射调用耗时："+(end-start));
    }
    public void noCheckedReflection(Test test) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = test.getClass().getDeclaredMethod("getName");
        m.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            m.invoke(test);
        }
        long end = System.currentTimeMillis();
        System.out.println("不进行检查的反射调用耗时："+(end-start));
    }

}
class Test{
    public String name;

    public Test() {
    }

    public String getName() {
        return name;
    }
}
