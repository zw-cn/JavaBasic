package com.zw.reflection;

import com.zw.annotation.my.MyAuthor;
import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: JavaBasic
 * @description: JavaAssistAPI
 * @author: zw-cn
 * @create: 2020-02-22 20:32
 */
public class Reflection_07_Javaassist_02 {
    public static void main(String[] args) throws Exception {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
        test06();

    }
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass c = pool.get("com.zw.reflection.User");

        byte[] bytes = c.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        System.out.println(c.getSuperclass());
        System.out.println(c.getInterfaces());
    }
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zw.reflection.User");

        CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{return $1+$2;}");
        cc.addMethod(m);

        Class clazz = cc.toClass();
        Object o = clazz.getConstructor().newInstance();
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(o,100 ,200);
        System.out.println(result);
    }
    /**
     * @description: 修改方法
     * @param
     * @return: void
     * @author: zw-cn
     * @time: 2/23/2020 10:39 AM
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass c = pool.get("com.zw.reflection.User");

        CtMethod m = c.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        m.insertBefore("System.out.println(\"insertBefore!\"+$1);");
        m.insertAt(107,"System.out.println(\"insetAt\");");
        m.insertAfter("System.out.println(\"insertAfter!\"+$1);");

        Class rc = c.toClass();
        Object o = rc.newInstance();
        Method rm = rc.getDeclaredMethod("sayHello",int.class);
        rm.invoke(o,16);
    }

    /**
     * @description: 修改属性，添加getter/setter方法
     * @param
     * @return: void
     * @author: zw-cn
     * @time: 2/23/2020 11:09 AM
     */
    public static void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass c = pool.get("com.zw.reflection.User");

//        CtField field = CtField.make("private int salary;");
        CtField field = new CtField(CtClass.intType,"salary",c);
        field.setModifiers(Modifier.PRIVATE);
        c.addField(field);
        c.getDeclaredField("salary");

        c.addMethod(CtNewMethod.getter("getSalary", field));
        c.addMethod(CtNewMethod.setter("setSalary",field));
    }
    /**
     * @description: 构造器
     * @param 
     * @return: void
     * @author: zw-cn
     * @time: 2/23/2020 11:32 AM
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zw.reflection.User");

        CtConstructor[]  cs = cc.getConstructors();
        for (CtConstructor constructor : cs) {
            constructor.insertBefore("System.out.println(\"所有的构造器都听我的！\");");
            System.out.println(constructor.getLongName());
        }

        Class clazz = cc.toClass();
        Object o = clazz.newInstance();
    }

    /**
     * @description: 注解
     * @param 
     * @return: void
     * @author: zw-cn
     * @time: 2/23/2020 11:33 AM
     */
    public static void test06() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.zw.reflection.Point");

        Object[] all = cc.getAnnotations();
        MyAuthor ma = (MyAuthor) all[0];
        String name = ma.name();
        int year = ma.year();
        System.out.println("name="+name+",year="+year);
    }
}
@MyAuthor(name="Sun",year=19)
class Point{
    int x,y;
}
