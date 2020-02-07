package com.zw.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: JavaBasic
 * @description: URL的基本使用
 * @author: zw-cn
 * @create: 2020-02-07 15:18
 */
public class Net_01_URL {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.zw.com:80/index.jsp?username=1&age=2#a");
        System.out.println("协议："+url.getProtocol());
        System.out.println("host:"+url.getHost());
        System.out.println("port:"+url.getPort());
        System.out.println("resources1:"+url.getFile());
        System.out.println("resources2:"+url.getPath());
        System.out.println("param:"+url.getQuery());
        System.out.println("ref:"+url.getRef());
    }
}
