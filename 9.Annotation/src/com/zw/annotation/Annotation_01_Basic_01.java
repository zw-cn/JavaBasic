package com.zw.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 注解的基本使用
 * @author: zw-cn
 * @create: 2020-02-18 22:24
 */
public class Annotation_01_Basic_01 {
    /*常见内置注解3个*/
    @Override /*1:自类重写父类的方法@Override*/
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Date date = new Date();
        /*2. 过时的方法@Deprecated*/
        date.parse("dd");

        /*3:抑制警告信息@SuppressWarnings("All")*/
        /* 参数:说明
         * deprecation:使用了过时方法的警告
         * unchecked:未检查的转换时警告，例如使用集合未指定泛型
         * fallthrough:switch中发生case穿透
         * path:在类、源文件路径中有不存在路径的警告
         * serial:在可序列化的类中缺少serialVisionUID定义的警告
         * finally:任何finally子句不能完成时的警告
         * all:以上所有
         */

        @SuppressWarnings({"all"})
        List list = new ArrayList();
        list.add("aaa");
    }
}
