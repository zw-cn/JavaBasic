package com.zw.jdk10;

import java.io.*;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: Reader的TransferTo方法</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_05_Reader_transferTo {
    public static void main(String[] args) {
        try {
            var br = new BufferedReader(new InputStreamReader(new FileInputStream("./15.JDK10/doc/a.txt"),"gbk"));
            var pw = new PrintWriter(new FileWriter("./15.JDK10/doc/c.txt"));//默认UTF8编码
            br.transferTo(pw);
            pw.flush();
            pw.close();
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
