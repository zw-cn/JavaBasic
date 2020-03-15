package com.zw.sorm.utils;

/**
 * @program: JavaBasic
 * @description: 封装字符串常用操作
 * @author: zw-cn
 * @create: 2020-03-13 16:38
 */
public class StringUtils {
    public static String firstChar2UpperCase(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
