package com.zw.net;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: JavaBasic
 * @description: http请求-爬虫-模拟浏览器
 * @author: zw-cn
 * @create: 2020-02-07 16:21
 */
public class Net_01_Http {
    public static void main(String[] args) throws Exception {
        Net_01_Http m = new Net_01_Http();
        m.spider();
        m.spiderLikeBrowser();
    }
    public void spider() throws Exception{
        URL url = new URL("https://www.jd.com");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String msg = null;
        while(null != (msg = br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
    public void spiderLikeBrowser() throws Exception{
        URL url = new URL("https://www.dianping.com");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String msg = null;
        while(null != (msg = br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
}
