package com.zw.jdk10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: 新增3个新的构造方法，额外的参数来指定字符集</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_04_PrintWriter_Stream_constructor {
    public static void main(String[] args) {
        var str = "我是中国人，我爱中国";
        try {
            System.out.println(new File("./15.JDK10/doc").getAbsolutePath());
            var p = new PrintWriter("./15.JDK10/doc/a.txt","gbk");
            p.println(str);
            p.flush();
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
