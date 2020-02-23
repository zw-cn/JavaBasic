package com.zw.reflection;

import javassist.*;

/**
 * @program: JavaBasic
 * @description: 字节码操作
 * @author: zw-cn
 * @create: 2020-02-20 15:41
 */
public class Reflection_07_Javaassist {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.zw.reflection.bean.Emp");

        //创建属性
        CtField f1 = CtField.make("private int id;",cc);
        CtField f2 = CtField.make("private String name;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public void setName(String name){this.name = name;}",cc);
        CtMethod m2 = CtMethod.make("public String getName(){return name;}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor ccs = new CtConstructor(new CtClass[] {CtClass.intType,pool.get("java.lang.String")},cc);
        ccs.setBody("{this.id = $1;this.name = $2;}");//传递参数使用$表示
        cc.addConstructor(ccs);

        cc.writeFile("./9.Annotation/doc/Emp");//输出.class文件
    }
}
