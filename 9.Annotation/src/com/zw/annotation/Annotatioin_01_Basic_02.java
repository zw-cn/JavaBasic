package com.zw.annotation;

import com.zw.annotation.my.ORMColumn;
import com.zw.annotation.my.ORMTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @program: JavaBasic
 * @description: 元注解和自定义注解
 * @author: zw-cn
 * @create: 2020-02-18 22:52
 */
public class Annotatioin_01_Basic_02 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.zw.annotation.Sutdent");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            ORMTable ormTable = (ORMTable) clazz.getAnnotation(ORMTable.class);
            System.out.println(ormTable.value());

            Field field = clazz.getDeclaredField("college");
            ORMColumn ormColumn = field.getAnnotation(ORMColumn.class);
            System.out.println("name:"+ormColumn.name()+",type="+ormColumn.type()+",len="+ormColumn.len());

            //根据获取到的信息，生成DDL语句，通过JDBC在数据库中执行
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
@ORMTable(value = "tb_STU")
class Sutdent{
    @ORMColumn(name = "age", type = "int", len = 3)
    private int age = 0;
    @ORMColumn(name = "name", type = "varchar", len = 100)
    private String name;
    @ORMColumn(name = "college", type = "varchar", len = 200)
    private String college;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}