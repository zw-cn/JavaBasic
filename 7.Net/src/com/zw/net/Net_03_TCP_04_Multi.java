package com.zw.net;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: TCP 多线程+封装
 * @author: zw-cn
 * @create: 2020-02-10 12:16
 */
public class Net_03_TCP_04_Multi {
}

class TCPServer04 {
    public TCPServer04() {
    }

    public static void main(String[] args) throws IOException {
        //1. 建立TCPServerSocket
        ServerSocket server = new ServerSocket(9000);
        //2. 等待客户端
        boolean run = true;
        while (run) {
            //3. 处理数据
            Socket socket = server.accept();
            new Thread(new Channel(socket)).start();
        }

        //4. 关闭资源
        server.close();
    }

    static class Channel implements Runnable {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public Channel(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String[] datas = new String[0];
            try {
                String username = null;
                String password = null;
                datas = dis.readUTF().split("&");
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
                if ("zw".equals(username) && "1234".equals(password)) {
                    dos.writeUTF("欢迎回来" + username);
                } else {
                    dos.writeUTF("用户名或密码错误");
                }
                dos.flush();
                closeAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void closeAll() {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TCPClient04 {

    public static void main(String[] args) throws IOException {
        //1. 建立连接：指定主机和端口
        Socket socket = new Socket("localhost", 9000);
        //2. 生成并发送数据+接收数据
        Send send = new Send(socket);
        Receive receive = new Receive(socket);
        send.send();
        System.out.println(receive.receive());
        //3. 关闭连接
        socket.close();
    }
    /**
     * @description: 将发送行为封装为一个类
     * @author: zw-cn
     * @create: 2020/2/10 13:27
     */
    static class Send {
        private Socket socket;
        private DataOutputStream dos;
        private String msg;

        private String init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("输入用户名");
            String username = br.readLine();
            System.out.println("输入密码");
            String password = br.readLine();
            br.close();
            return "username=" + username + "&" + "password=" + password;
        }

        public Send(Socket socket) {
            this.socket = socket;
            try {
                this.msg = init();
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send() {
            try {
                dos.writeUTF(msg);
                dos.flush();
//                dos.close();//此处关闭输出流会导致接收报socket closed异常
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @description: 将接收行为封装为一个类
     * @author: zw-cn
     * @create: 2020/2/10 13:27
     */
    static class Receive {
        private Socket socket;
        private DataInputStream dis;

        public Receive(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String receive() {
            String msg = null;
            try {
                msg = dis.readUTF();
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
        }
    }
}