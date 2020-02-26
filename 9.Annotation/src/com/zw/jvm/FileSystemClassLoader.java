package com.zw.jvm;

import java.io.*;
import java.net.URL;

/**
 * @program: JavaBasic
 * @description: 自定义类加载器
 * @author: zw-cn
 * @create: 2020-02-24 19:49
 */
public class FileSystemClassLoader extends ClassLoader{
    private String root;

    public FileSystemClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);
        if(c != null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
            }
            if(c != null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if (classData == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String name) {
        String path = root +"/" + name.replace('.','/')+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try{
            is = new FileInputStream(path);
            int len = 0;
            while ((len = is.read(buffer))>0){
                baos.write(buffer,0,len);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
}

class FileSystemClassLoaderTest{
    public static void main(String[] args) throws ClassNotFoundException {
        File f = new File("./9.Annotation/doc/Emp");
        FileSystemClassLoader loader = new FileSystemClassLoader(f.getAbsolutePath());
        FileSystemClassLoader loader2 = new FileSystemClassLoader(f.getAbsolutePath());
        Class c = loader.findClass("com.zw.reflection.bean.Emp");
        Class c2 = loader.findClass("com.zw.reflection.bean.Emp");
        Class c3 = loader2.findClass("com.zw.reflection.bean.Emp");
        System.out.println(c.hashCode()==c2.hashCode());//同一个类加载器同一个类名的类才会被认为是同一个
        System.out.println(c.hashCode() == c3.hashCode());//不同类加载器或者不同类名的类不会被认为是同一个
        System.out.println(c.getClassLoader());//获得类加载器
    }
}
/**
 * @description: 网络类加载器
 * @author: zw-cn
 * @create: 2/25/2020 5:08 PM
 */
class URLClassLoader extends ClassLoader{
    private String root;

    public URLClassLoader(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);
        if(c != null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
            }
            if(c != null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if (classData == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String name) {
        String path = root +"/" + name.replace('.','/')+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try{
            URL url = new URL(path);
            is = url.openStream();
            int len = 0;
            while ((len = is.read(buffer))>0){
                baos.write(buffer,0,len);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
}