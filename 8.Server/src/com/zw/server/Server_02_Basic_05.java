package com.zw.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: 添加分发器
 * @author: zw-cn
 * @create: 2020-02-18 16:08
 */
public class Server_02_Basic_05 {
    private ServerSocket serverSocket;
    private boolean isRunning;

    public static void main(String[] args) {
        Server_02_Basic_05 basic = new Server_02_Basic_05();
        basic.start();
    }
    public void start() {
        try {
            serverSocket = new ServerSocket(9000);
            isRunning = true;
            receive();
        } catch (IOException e) {
            System.out.println("客户端连接失败" + e.getMessage());
            isRunning = false;
            stop();
        }
    }

    public void receive() {
        Socket socket = null;
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println("一个客户端建立了连接！");
                new Thread(new Dispatcher(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("获取数据失败" + e.getMessage());
        }
    }

    public void stop(){
        isRunning = false;
        try {
            serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Dispatcher implements Runnable{
    private Socket socket;
    private Requset03 req;
    private Response03 response;

    public Dispatcher(Socket socket) {
        this.socket = socket;
        try {
            req = new Requset03(socket);
            response = new Response03(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if(null ==req.getUrl() ||"".equals(req.getUrl())){
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("pages/index.html");
            try {
                response.print(new String(is.readAllBytes()));//jdk9才有的方法
                response.push(200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Servlet03 servlet = webApps.getServletFormURL(req.getUrl());
            if (null!=servlet){
                servlet.service(req,response);
                response.push(200);
            }else {
                response.print("资源不存在！");
                response.push(404);
            }
        }
        release();
    }
    private void release(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}