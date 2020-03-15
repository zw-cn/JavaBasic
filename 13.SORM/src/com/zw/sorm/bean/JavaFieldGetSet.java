package com.zw.sorm.bean;

/**
 * @program: JavaBasic
 * @description: 封装生成Java类的属性、getter、setter方法源码
 * @author: zw-cn
 * @create: 2020-03-13 22:59
 */
public class JavaFieldGetSet {
    /**
     * 属性的源码信息。如:private int id;
     */
    private String fieldInfo;
    /**
     * getter方法的源码信息。如: public Integer getId(){return id;}
     */
    private String getInfo;
    /**
     * setter方法的源码信息。如:public void setId(Integer id){this.id = id;}
     */
    private String setInfo;

    public JavaFieldGetSet() {
    }

    public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }

    @Override
    public String toString() {
        return fieldInfo + '\n' +
               getInfo + '\n' +
               setInfo + '\n' ;
    }
}
