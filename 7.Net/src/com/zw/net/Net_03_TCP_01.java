package com.zw.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: TCP的基本使用
 * @author: zw-cn
 * @create: 2020-02-09 18:30
 */
public class Net_03_TCP_01 {
}
/**
 * @description: TCP 服务器端
 * 1. 创建ServerSocket,指定端口
 * 2. ServerSocket.accept()阻塞，当有客户端连接时返回Socket对象
 * 3. 使用Socket获取输入输出流，并处理
 * 4. 关闭资源
 * @author: zw-cn
 * @create: 2020/2/9 18:53
 */
class TCPServer{
    public static void main(String[] args) throws IOException {
        System.out.println("Server is running!");
        ServerSocket server = new ServerSocket(9000);
        Socket client = server.accept();//这里没有连接将会阻塞
        System.out.println("An client has connected!");
        DataInputStream dos = new DataInputStream(client.getInputStream());
        System.out.println(dos.readUTF());
        dos.close();
        client.close();
        server.close();
    }
}
/**
 * @description: TCP 客户端
 * 1. 创建Socket,指定IP和端口
 * 2. 使用Socket获取输入输出流，并处理
 * 3. 关闭资源
 * @author: zw-cn
 * @create: 2020/2/9 18:57
 */
class TCPClient{
    public static void main(String[] args) throws IOException {
        System.out.println("Client is running!");
        Socket socket = new Socket("localhost",9000);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("Hello server!");
        dos.flush();
        dos.close();
        socket.close();
    }
}