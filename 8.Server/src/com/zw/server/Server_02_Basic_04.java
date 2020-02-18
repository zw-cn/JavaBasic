package com.zw.server;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: JavaBasic
 * @description: 使用反射
 * @author: zw-cn
 * @create: 2020-02-18 15:16
 */
public class Server_02_Basic_04 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server_02_Basic_04 basic = new Server_02_Basic_04();
        basic.start();
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
                Requset03 req = new Requset03(is);
                Response03 response = new Response03(socket);

                Servlet03 servlet = webApps.getServletFormURL(req.getUrl());
                if (null!=servlet){
                    servlet.service(req,response);
                }else {
                    response.print("资源不存在！");
                    response.push(404);
                }

            }
        } catch (IOException e) {
            System.out.println("获取数据失败" + e.getMessage());
        }
    }
}
class webApps{
    public static WebContext webContext;
    static {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            WebXMLHandler webXMLHandler = new WebXMLHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xmls/web.xml"), webXMLHandler);
            System.out.println(webXMLHandler.toString());
            webContext = new WebContext(webXMLHandler.getServletList(), webXMLHandler.getMappingList());
        } catch (Exception e) {
            System.out.println("解析xml出错"+e.getMessage());
        }
    }
    static Servlet03 getServletFormURL(String Url){
        try {
            Servlet03 servlet = (Servlet03)Class.forName(webContext.getClazz("/"+Url)).getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}