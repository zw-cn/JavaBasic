package com.zw.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @program: JavaBasic
 * @description: UDP网络编程
 * @author: zw-cn
 * @create: 2020-02-07 17:11
 */
public class Net_02_UDP_01 {

}
/**
 * @description: UDP接收端
 * @author: zw-cn
 * @create: 2020/2/7 17:12
 */
class UDPServer{

    public static void main(String[] args) throws Exception {
        //1. 创建socket，指定端口
        DatagramSocket socket = new DatagramSocket(65500);
        //2. 创建数据包
        byte[] buffer = new byte[60*1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        //3. 接收数据
        socket.receive(packet);
        //4. 处理数据
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        //5. 关闭socket
        socket.close();
    }
}
class UDPClient{
    public static void main(String[] args) throws Exception {
        //1.创建socket
        DatagramSocket socket = new DatagramSocket(65501);
        //2.创建数据包
        byte[] datas;
        datas = "hello form UDPClient".getBytes();
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",65500));
        //3. 发送数据
        socket.send(packet);
        //4.关闭
        socket.close();
    }
}