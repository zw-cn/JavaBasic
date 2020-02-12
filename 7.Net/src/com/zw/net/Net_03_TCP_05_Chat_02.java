package com.zw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: JavaBasic
 * @description: 改进：封装
 * @author: zw-cn
 * @create: 2020-02-10 16:03
 */
public class Net_03_TCP_05_Chat_02 {
}

/**
 * @description: 将释放资源抽取为工具类中的方法
 * @author: zw-cn
 * @create: 2020/2/10 16:06
 */
class NetUtil {
    public static void release(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * @description: 封装后的服务端
 * @author: zw-cn
 * @create: 2020/2/10 17:27
 */
class TCPServer0502 {
    private static CopyOnWriteArrayList<Channel> allChatRoom = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            Socket client = server.accept();
            Channel c = new Channel(client);
            allChatRoom.add(c);
            new Thread(c).start();
        }
    }

    static class Channel implements Runnable {
        private Socket client;
        private boolean isRunning;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String name;

        public Channel(Socket client) {
            this.client = client;
            isRunning = true;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                release();
            }
            this.name = recevie();
            this.send(this.name + ",欢迎加入群聊！");
            this.sendToAll(this.name + "加入了群聊", true);
        }
        /**
         * @description: 接收方法
         * @param 
         * @return: java.lang.String
         * @author: zw-cn
         * @time: 2020/2/12 16:15
         */
        private String recevie() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("Server接收异常" + e.getMessage());
                release();
            }
            return msg;
        }
        /**
         * @description: 发送方法
         * @param msg
         * @return: void
         * @author: zw-cn
         * @time: 2020/2/12 16:15
         */
        private void send(String msg) {
            try {

                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("Server发送异常" + e.getMessage());
                release();
            }
        }

        private void sendToAll(String msg, boolean system) {
            Pattern pattern = Pattern.compile("^@(?<target>.+):(?<message>.*)$");
            Matcher matcher = pattern.matcher(msg);
            for (Channel others : allChatRoom) {
                if (others == this) {
                    continue;
                }
                if (matcher.find()) {//私聊
                    if (matcher.group("target").equals(others.name)) {
                        others.send(this.name+"对您悄悄说"+matcher.group("message"));
                        break;
                    }
                } else {//群聊
                    if (system) {
                        others.send("[公告：]" + msg);
                    } else {
                        others.send(this.name + "：" + msg);

                    }
                }
            }
        }

        private void release() {
            isRunning = false;
            NetUtil.release(dos, dis, client);
            allChatRoom.remove(this);
            sendToAll(this.name + "离开了群聊", true);
        }


        @Override
        public void run() {
            while (isRunning) {
                String msg = "";
                msg = recevie();
                if (!"".equals(msg)) {
                    sendToAll(msg, false);
                }
            }
        }
    }

}

class TCPClient0502 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入用户名");
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String name = nameReader.readLine();
        Socket socket = new Socket("localhost", 9000);
        new Thread(new Send(socket, name)).start();
        new Thread(new Receive(socket)).start();
    }

    static class Send implements Runnable {
        private Socket socket;
        private DataOutputStream dos;
        private boolean isRunning;
        private BufferedReader console;
        private String name;

        public Send(Socket socket, String name) {
            this.socket = socket;
            this.isRunning = true;
            this.name = name;
            try {
                console = new BufferedReader(new InputStreamReader(System.in));
                dos = new DataOutputStream(socket.getOutputStream());
                send(name);
            } catch (IOException e) {
                this.isRunning = false;
                NetUtil.release(dos, socket);
            }
        }

        private void send(String msg) {
            try {

                if (!"".equals(msg)) {
                    dos.writeUTF(msg);
                    dos.flush();
                }
            } catch (IOException e) {
                this.isRunning = false;
                NetUtil.release(dos, socket);
                System.out.println("Client 发送出错" + e.getMessage());
            }
        }

        private String getConsole() {
            try {
                return console.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = getConsole();
                if (!"".equals(msg)) {
                    send(msg);
                }
            }
        }
    }

    static class Receive implements Runnable {
        private Socket socket;
        private DataInputStream dis;
        private boolean isRunning;

        public Receive(Socket socket) {
            this.socket = socket;
            this.isRunning = true;
            try {
                dis = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                this.isRunning = false;
                NetUtil.release(dis, socket);
            }
        }

        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                this.isRunning = false;
                NetUtil.release(dis, socket);
                System.out.println("Client 接收出错" + e.getMessage());
            }
            return msg;
        }

        @Override
        public void run() {
            while (isRunning) {
                System.out.println(receive());
            }
        }
    }
}

