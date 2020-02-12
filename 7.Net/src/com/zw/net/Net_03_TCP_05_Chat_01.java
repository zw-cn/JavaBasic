package com.zw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: TCP实现聊天室
 * @author: zw-cn
 * @create: 2020-02-10 14:57
 */
public class Net_03_TCP_05_Chat_01 {
}
class TCPServer05{
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        boolean isRunning = true;
        while (true){
            Socket client = server.accept();
            new Thread(()->{
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                    while (isRunning) {
                        String msg = "";
                        msg = dis.readUTF();
                        dos.writeUTF(msg);
                        dos.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        dis.close();
                        dos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
//        client.close();
//        server.close();
    }
}
class TCPClient05{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);
        boolean isRunning = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        while(isRunning){
            String msg = reader.readLine();
            dos.writeUTF(msg);
            dos.flush();
            System.out.println(dis.readUTF());
        }
        dos.close();
        dis.close();
        reader.close();
        socket.close();
    }
}