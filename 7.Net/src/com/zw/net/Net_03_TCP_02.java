package com.zw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: TCP双向连接+字符解析
 * @author: zw-cn
 * @create: 2020-02-09 19:11
 */
public class Net_03_TCP_02 {
}

class TCPServer2 {
    public static void main(String[] args) throws IOException {
        //1. 建立TCPServerSocket
        ServerSocket server = new ServerSocket(9000);
        //2. 等待客户端
        Socket socket = server.accept();
        //3. 处理数据
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String[] datas = dis.readUTF().split("&");
        String username = null;
        String password = null;
        for (String info : datas) {
            System.out.println(info);
            if (info.split("=")[0].equals("username")) {
                username = info.split("=")[1];
            }
            if (info.split("=")[0].equals("password")) {
                password = info.split("=")[1];
            }
        }
        System.out.println("用户:" + username + "密码:" + password);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        if ("zw".equals(username) && "1234".equals(password)) {
            dos.writeUTF("欢迎回来" + username);
        } else {
            dos.writeUTF("用户名或密码错误");
        }
        System.out.println("写完了");
        dos.flush();
        //4. 关闭资源
        dos.close();
        dis.close();
        socket.close();
        server.close();
    }
}

class TCPClient2 {
    public static void main(String[] args) throws IOException {
        String username = null;
        String password = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入用户名");
        username = br.readLine();
        System.out.println("输入密码");
        password = br.readLine();
        br.close();
        //1. 建立连接：指定主机和端口
        Socket socket = new Socket("localhost", 9000);
        //2. 生成并发送数据+接收数据
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("username=" + username + "&" + "password=" + password);
        dos.flush();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF());
        //3. 关闭连接
        dis.close();
        dos.close();
        socket.close();

    }
}