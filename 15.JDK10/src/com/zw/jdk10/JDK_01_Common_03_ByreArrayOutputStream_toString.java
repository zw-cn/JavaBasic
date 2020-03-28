package com.zw.jdk10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: 指定字符集输出缓冲区</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_03_ByreArrayOutputStream_toString {
    /**
     * <p>Description: ByteArrayOutputStream重载toString()方法</p>
     *
     * @param args
     * @return void
     * @throws
     * @author zw-cn
     * @date: 3/25/2020 1:08 PM
     */
    public static void main(String[] args) {
        var str = "我是中国人，我爱中国";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("GBK"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            var s = 0;
            while ((s = bis.read()) != -1){
                bos.write(s);
            }
            System.out.println(bos.toString());
            System.out.println(bos.toString("GBK"));
            System.out.println(bos.toString(Charset.forName("GBK")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
