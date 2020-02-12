package com.zw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private static CopyOnWriteArrayList<Channel> allChatRoom;
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

        public Channel(Socket client) {
            this.client = client;
            isRunning = true;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                NetUtil.release(dos, dis, client);
            }
        }

        private String recevie() {
            String msg = "";
            try {

                msg = dis.readUTF();
            } catch (IOException e) {
                isRunning = false;
                System.out.println("Server接收异常" + e.getMessage());
                NetUtil.release(dis, client);
            }
            return msg;
        }

        private void send(String msg) {
            try {

                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                isRunning = false;
                System.out.println("Server发送异常" + e.getMessage());
                NetUtil.release(dos, client);
            }
        }

        private void sendToAll(String msg){
            for(Channel others : allChatRoom){
                
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = "";
                msg = recevie();
                if (!"".equals(msg)) {
                    send(msg);
                }
            }
        }
    }

}

class TCPClient0502 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        new Thread(new Send(socket)).start();
        new Thread(new Receive(socket)).start();
//        socket.close();
    }

    static class Send implements Runnable {
        private Socket socket;
        private DataOutputStream dos;
        private boolean isRunning;
        private BufferedReader console;

        public Send(Socket socket) {
            this.socket = socket;
            this.isRunning = true;
            try {
                console = new BufferedReader(new InputStreamReader(System.in));
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                this.isRunning = false;
                NetUtil.release(dos, socket);
            }
        }

        private void send() {
            try {
                String msg = console.readLine();
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

        @Override
        public void run() {
            while (isRunning){
                send();
            }
        }
    }
    static class Receive implements Runnable{
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
        private String receive(){
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
            while(isRunning){
                System.out.println(receive());
            }
        }
    }
}

