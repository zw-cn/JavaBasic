package com.zw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: TCP实现文件的上传
 * @author: zw-cn
 * @create: 2020-02-10 00:26
 */
public class Net_03_TCP_03_FileUpload {
}
/**
 * @description: 文件上传服务端
 * @author: zw-cn
 * @create: 2020/2/10 1:13
 */
class TCPServer03 {
    public static void main(String[] args) throws IOException {
        //1. 建立服务
        ServerSocket server = new ServerSocket(9000);
        //2. 监听客户端的访问
        Socket client = server.accept();
        //3. 处理数据
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("7.Net/resources/music/最甜情歌.mp3.bak"));
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        //4. 释放资源
        os.close();
        is.close();
        client.close();
        server.close();
    }
}
/**
 * @description: 文件上传客户端
 * @author: zw-cn
 * @create: 2020/2/10 1:13
 */
class TCPClient03 {
    public static void main(String[] args) throws IOException {
        //1. 建立socket 指定主机+端口号
        Socket socket = new Socket("localhost", 9000);
        //2. 处理数据
        InputStream is = new BufferedInputStream(new FileInputStream("7.Net/resources/music/最甜情歌.mp3"));
        OutputStream os = new BufferedOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        //3. 释放资源
        os.close();
        is.close();
        socket.close();
    }
}