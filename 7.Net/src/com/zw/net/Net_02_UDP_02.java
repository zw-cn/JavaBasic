package com.zw.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @program: JavaBasic
 * @description: 传递多次数据
 * @author: zw-cn
 * @create: 2020-02-07 18:14
 */
public class Net_02_UDP_02 {
    public static void main(String[] args) {
        new Thread(new UDPServer02("server",9000)).start();
        new Thread(new UDPClient02("client",9001,9000,"localhost")).start();
        new Thread(new UDPServer02("client",9002)).start();
        new Thread(new UDPClient02("server",9003,9002,"localhost")).start();
    }
}
class UDPClient02 implements Runnable{
    private String host;
    private int localPort;
    private int targetPort;
    private String targetHost;

    public UDPClient02(String host, int localPort, int targetPort, String targetHost) {
        this.host = host;
        this.localPort = localPort;
        this.targetPort = targetPort;
        this.targetHost = targetHost;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(localPort);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            byte[] sendMessage = null;
            while(null!=(msg=br.readLine())){
                sendMessage = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(sendMessage, sendMessage.length, new InetSocketAddress(targetHost,targetPort));
                socket.send(packet);
                if ("exit".equals(msg)) {
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UDPServer02 implements Runnable{
    private String host;
    private int localPort;

    public UDPServer02(String host, int localPort) {
        this.host = host;
        this.localPort = localPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(localPort);
            while(true){
                byte[] msg = new byte[60*1024];
                DatagramPacket packet = new DatagramPacket(msg,0,msg.length);
                socket.receive(packet);
                String receiveMsg = new String(packet.getData(),0,packet.getLength());
                System.out.println(host+":"+receiveMsg);
                if("exit".equals(receiveMsg)){
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Teacher{
    public static void main(String[] args) {
        new Thread(new UDPServer02("Student",9000)).start();
        new Thread(new UDPClient02("Teacher",9001,9002,"localhost")).start();
    }
}
class Student{
    public static void main(String[] args) {
        new Thread(new UDPServer02("Teacher",9002)).start();
        new Thread(new UDPClient02("Student",9003,9000,"localhost")).start();
    }
}