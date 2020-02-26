package com.zw.jvm;

import java.io.*;

/**
 * @program: JavaBasic
 * @description: 加密class类加载器
 * @author: zw-cn
 * @create: 2020-02-26 07:45
 */
public class EncryptClassLoader extends ClassLoader {
    String root;

    public EncryptClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        }
        ClassLoader parent = this.getParent();
        try {
            clazz = parent.loadClass(name);
        } catch (ClassNotFoundException e) {
        }
        if (clazz != null) {
            return clazz;
        } else {
            byte[] data = getData(name);
            data = EncryptUtil.decrypt(data);//解密（取反）
            clazz = defineClass(name, data, 0, data.length);
        }
        return clazz;
    }

    private byte[] getData(String name) {
        String path = root +"/"+ name.replace(".", "/") + ".class";
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

}

class EncryptClassLoaderTest {
    public static void main(String[] args) {
        File f = new File("./9.Annotation/doc");
        File enf = new File(f.getPath() + "/encrypt");
        if (!enf.exists()) {
            enf.mkdirs();
        }
        EncryptUtil.encrypt(f.getAbsolutePath() + "/HelloWorld.class", f.getAbsolutePath() + "/encrypt/HelloWorld.class");
        EncryptClassLoader loader = new EncryptClassLoader(enf.getAbsolutePath());
        FileSystemClassLoader commonLoader = new FileSystemClassLoader(enf.getAbsolutePath());
        try {
            Class c = loader.findClass("HelloWorld");
            System.out.println(c.hashCode());
            Class cf = commonLoader.findClass("HelloWorld");//普通的类加载器无法加载
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
