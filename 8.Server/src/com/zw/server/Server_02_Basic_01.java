package com.zw.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @program: JavaBasic
 * @description:
 * @author: zw-cn
 * @create: 2020-02-15 18:45
 */
public class Server_02_Basic_01 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server_02_Basic_01 server = new Server_02_Basic_01();
        server.start();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(9000);
            receive();
        } catch (IOException e) {
            System.out.println("客户端连接失败" + e.getMessage());
        }
    }

    public void receive() {
        Socket socket = null;
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println("一个客户端建立了连接！");
                InputStream is = socket.getInputStream();
                byte[] datas = new byte[1024 * 1024];
                int len = is.read(datas);
                if (len > 0) {
                    System.out.println(new String(datas, 0, len));
                    response(socket);
                }
            }
        } catch (IOException e) {
            System.out.println("获取数据失败" + e.getMessage());
        }
    }

    public void response(Socket socket) {
        try {

            StringBuilder content = new StringBuilder();
            content.append("<!DOCTYPE html>");
            content.append("<html>");
            content.append("<head>");
            content.append("<meta charset=\"utf-8\"/>");
            content.append("</head>");
            content.append("<body>");
            content.append("the server responded strongly <br/> 服务器给予强烈的回应");
            content.append("</body>");
            content.append("</html>");

            int size = content.toString().getBytes().length;

            String blank = " ";
            String CRLF = "\r\n";
            StringBuilder res = new StringBuilder();
            res.append("HTTP1.1").append(blank);
            res.append("200").append(blank);
            res.append("OK").append(CRLF);

            res.append("Date:").append(new Date()).append(CRLF);
            res.append("Server:").append("zw Server/0.0.1;charset=UTF-8").append(CRLF);
            res.append("Content-type:text/html").append(CRLF);
            res.append("Content-length:").append(size).append(CRLF);
            res.append(CRLF);
            res.append(content);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(res.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stop() {

    }
}
