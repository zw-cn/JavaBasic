package com.zw.jdbc.tools;

import java.io.Closeable;
import java.io.IOException;

/**
 * @program: JavaBasic
 * @description: 工具类
 * @author: zw-cn
 * @create: 2020-03-12 12:11
 */
public class Utils {
    public static void closeThem(Closeable... target) {
        for (Closeable current : target) {
            if (current != null) {
                try {
                    current.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void closeThem(AutoCloseable... target) {
        for (AutoCloseable current : target) {
            if (current != null) {
                try {
                    current.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
