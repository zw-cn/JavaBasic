package com.zw.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @program: JavaBasic
 * @description: 正则爬虫
 * @author: zw-cn
 * @create: 2020-03-10 18:16
 */
public class Regex_02_Spider {
    public static void main(String[] args) {
        String str = getContent("http://www.163.com","gbk");
//        Regex_01_Common.matchRegex("<a[\\s\\S]+?</a>",str);
        Regex_01_Common.matchRegex("href=\"([\\w\\s:/.]+)\"",str,1);
    }
    public static String getContent(String strUrl,String encoding){
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(strUrl);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(encoding)));
            String temp;
            while((temp = bufferedReader.readLine()) !=null){
                result.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
