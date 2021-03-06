package com.zw.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * @program: JavaBasic
 * @description: 将响应信息封装为类
 * @author: zw-cn
 * @create: 2020-02-16 15:36
 */
public class Server_02_Basic_03 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server_02_Basic_03 basic02 = new Server_02_Basic_03();
        basic02.start();
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

                if("login".equals(req.getUrl())){
                    Servlet03 servlet03 = new LoginServlet03();
                    servlet03.service(req,response);
                }
                if ("sign".equals(req.getUrl())){
                    Servlet03 servlet03 = new RegisterServlet03();
                    servlet03.service(req,response);
                }

            }
        } catch (IOException e) {
            System.out.println("获取数据失败" + e.getMessage());
        }
    }
}

/**
 * @description: 封装响应类
 * @author: zw-cn
 * @create: 2/16/2020 4:45 PM
 */
class Response03{
    private Socket client;
    private BufferedWriter bw;
    private StringBuilder content;
    private StringBuilder header;
    private int len;
    static final String BLANK = " ";
    static final String CRLF = "\r\n";

    public Response03() {
        content = new StringBuilder();
        header = new StringBuilder();
        len = 0;
    }
    public Response03(Socket client){
        this();
        this.client = client;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Response03(OutputStream os){
        this();
        this.bw = new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response03 print(String info){
        content.append(info);
        this.len += info.getBytes().length;
        return this;
    }
    public Response03 println(String info){
        print(info).print(CRLF);
        return this;
    }
    private void buildHeader(int code){
        header.append("HTTP1.1").append(BLANK);
        header.append(code).append(BLANK);
        switch (code){
            case 200:
                header.append("OK").append(CRLF);
                break;
            case 404:
                header.append("NOT FOUND").append(CRLF);
                break;
            case 500:
                header.append("SERVER ERROR").append(CRLF);
                break;
        }
        header.append("Date:").append(new Date()).append(CRLF);
        header.append("Server:").append("zw Server/0.0.1;charset=UTF-8").append(CRLF);
        header.append("Content-type:text/html").append(CRLF);
        header.append("Content-length:").append(len).append(CRLF);
        header.append(CRLF);
    }
    public void push(int code){
        if (content == null){
            code = 500;
        }
        buildHeader(code);
        try {
            bw.append(header);
            bw.append(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * @description: 封装请求类
 * @author: zw-cn
 * @create: 2/18/2020 2:55 PM
 */
class Requset03{
    private String type;
    private String url;
    private String param;
    private HashMap<String, List<String>> paramMap;

    public Requset03(Socket socket) throws IOException {
        this(socket.getInputStream());
    }
    public Requset03(InputStream is){
        byte[] buffer = new byte[1024*1024];
        try {
            int len = is.read(buffer);
            parseParams(new String(buffer,0 ,len));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseParams(String info){
        type = info.substring(0,info.indexOf('/')-1);
        url = info.substring(info.indexOf('/')+1,info.indexOf("HTTP/")-1);
        if(url.indexOf("?") >= 0){
            param = url.split("\\?")[1];
            url = url.split("\\?")[0];
        }
        if ("post".equals(type.toLowerCase())){
           String postBody=info.substring(info.lastIndexOf("\r\n")).trim();
           if(param != null){
               param += "&"+postBody;
           }else {
               param = postBody;
           }
        }
        param = param == null?"":param;
        System.out.println("type:"+type);
        System.out.println("url:"+url);
        System.out.println("param:"+param);
        convertParamMap();
    }

    private void convertParamMap(){
        paramMap = new HashMap<>();
        String[] paramArray = param.split("&");
        for(String params :paramArray){
            String[] kv = params.split("=");
            kv = Arrays.copyOf(kv,2);//处理空值
            String key = kv[0];
            String value = kv[1]==null?null:decode(kv[1],"utf-8");
            if(!paramMap.containsKey(key)){
                paramMap.put(key, new ArrayList<String>());
            }
            paramMap.get(key).add(value);
        }
    }
    private String decode(String value, String encoding){
        try {
            return URLDecoder.decode(value,encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String[] getParamValues(String key){
        List<String> values = paramMap.get(key);
        if(null == values || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    public String getParamValue(String key){
        String[] value = getParamValues(key);
        return value == null? null:value[0];
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}

interface Servlet03{
    void service(Requset03 request, Response03 response);
}
class LoginServlet03 implements Servlet03{
    public LoginServlet03() {
    }

    @Override
    public void service(Requset03 request, Response03 response) {
        response.print("<!DOCTYPE html>");
        response.print("<html>");
        response.print("<head>");
        response.print("<meta charset=\"utf-8\"/>");
        response.print("</head>");
        response.print("<body>");
        response.print("登录中。。。the server responded strongly<br/>"+request.getParamValue("name")+"<br/> 服务器给予强烈的回应");
        response.print("</body>");
        response.print("</html>");
        response.push(200);
    }
}
class RegisterServlet03 implements Servlet03{
    public RegisterServlet03() {
    }

    @Override
    public void service(Requset03 request, Response03 response) {
        response.print("<!DOCTYPE html>");
        response.print("<html>");
        response.print("<head>");
        response.print("<meta charset=\"utf-8\"/>");
        response.print("</head>");
        response.print("<body>");
        response.print("注册成功。。。the server responded strongly<br/>"+request.getParamValue("name")+"<br/> 服务器给予强烈的回应");
        response.print("</body>");
        response.print("</html>");
        response.push(200);
    }
}