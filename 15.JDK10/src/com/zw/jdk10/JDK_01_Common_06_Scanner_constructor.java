package com.zw.jdk10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: java.util.Formatter/Scanner新增3个构造器，可指定字符集</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_06_Scanner_constructor {
    public static void main(String[] args) {
        try {
            var scan = new Scanner(new FileInputStream("./15.JDK10/doc/a.txt"),"GBK");
            scan.useDelimiter(",|，|\\s");//指定分隔符
            while (scan.hasNext()){
                System.out.println(scan.next());//按照分隔符读取
                //System.out.println(scan.nextLine());//直接读取一行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
