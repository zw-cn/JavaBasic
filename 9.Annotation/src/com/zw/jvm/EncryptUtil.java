package com.zw.jvm;

import java.io.*;

/**
 * @program: JavaBasic
 * @description: 加密工具
 * @author: zw-cn
 * @create: 2020-02-25 17:06
 */
public class EncryptUtil {
    public static void encrypt(String src, String dest){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while ((temp=fis.read()) != -1){
                fos.write(~temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static byte[] decrypt(byte[] encryptData){
//        byte[] decrypt = new byte[encryptData.length];
//        System.arraycopy(encryptData,0,decrypt,0,encryptData.length);
        ByteArrayInputStream bais = new ByteArrayInputStream(encryptData);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int temp=0;
        while ((temp=bais.read()) != -1){
            baos.write(~temp);
        }
        return baos.toByteArray();

    }
    public static void main(String[] args) {
        int k=-15;
        System.out.println(Integer.toBinaryString(k));
        System.out.println(Integer.toBinaryString(k^0xff));//视频中的错误
        System.out.println(Integer.toBinaryString(k^0xffffffff));//异或取反
        System.out.println(Integer.toBinaryString(~k));//直接取反
        System.out.println(~k);//tip:~-n=-(-(n+1)),~n=-(n+1),结果=数值加一，符号取反，
    }
}
