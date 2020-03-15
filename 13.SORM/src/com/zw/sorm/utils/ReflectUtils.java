package com.zw.sorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaBasic
 * @description: 封装反射常用操作
 * @author: zw-cn
 * @create: 2020-03-13 16:40
 */
public class ReflectUtils {
    /**
     * @param field 对象的属性
     * @param obj 调用的对象
     * @description: 调用对象对应属性的Getter方法
     * @return: java.lang.Object getter方法的返回结果
     * @author: zw-cn
     * @time: 3/14/2020 9:13 PM
     */
    public static Object invokeGet(String field,Object obj){
        Class c = obj.getClass();
        try {
            Method m = c.getMethod("get"+StringUtils.firstChar2UpperCase(field),null);
            return m.invoke(obj,null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param obj 调用的对象
     * @param fieldName 属性名称
     * @param value 属性值
     * @description: 调用对象对应属性的Getter方法
     * @return: void
     * @author: zw-cn
     * @time: 3/15/2020 12:28 PM
     */
    public static void invokeSet(Object obj,String fieldName,Object value){
        Method m = null;
        try {
            m = obj.getClass().getDeclaredMethod("set"+ StringUtils.firstChar2UpperCase(fieldName),value.getClass());
            m.invoke(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
