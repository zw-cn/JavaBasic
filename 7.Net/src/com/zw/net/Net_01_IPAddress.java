package com.zw.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @program: JavaBasic
 * @description: IP的基本使用
 * @author: zw-cn
 * @create: 2020-02-07 13:49
 */
public class Net_01_IPAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();//获取主机信息
        System.out.println(host.getHostName());//主机名
        System.out.println(host.getHostAddress());//主机IP地址

        InetAddress baidu = InetAddress.getByName("www.baidu.com");//根据域名获取IP
        System.out.println(baidu.getHostAddress());//根据DNS解析IP地址
        System.out.println(baidu.getHostName());//解析主机名

        InetAddress ip = InetAddress.getByName("127.0.0.1");
        System.out.println(ip.getHostName());//主机名
        System.out.println(ip.getHostAddress());//主机IP地址

        InetSocketAddress socketAddress = new InetSocketAddress("localhost",80);
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());
    }
}
