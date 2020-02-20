package com.zw.reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @program: JavaBasic
 * @description: 动态编译
 * @author: zw-cn
 * @create: 2020-02-19 17:56
 */
public class Reflection_05_DynamicCompile {

    public static void main(String[] args) {
        String path = "./9.Annotation/doc/HelloWorld.java";
        //compile(path);
        //compileBeforeJDK6(path);
        //runNoReflection(path);
        runReflection(path);
    }
    public static void compile(String path){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,path);
        System.out.println(result == 0? "编译成功":"编译失败");
    }
    public static void compileBeforeJDK6(String path){
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("javac "+path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runNoReflection(String path){
        File file = new File(path);
        String name = file.getName().split("\\.")[0];
        String fileParent = file.getParent();
        Runtime runtime = Runtime.getRuntime();
        try {
            System.out.println("java -cp "+fileParent+" "+name);
            Process process = runtime.exec("java -cp "+fileParent+" "+name);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String message="";
            while ((message = br.readLine())!=null){
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void runReflection(String path){
        try {
            File file = new File(new File(path).getParent());
            System.out.println(file.getAbsolutePath());
            URL[] urls = new URL[]{new URL("file:/"+file.getAbsolutePath()+"/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            Method m = c.getMethod("main",String[].class);
            m.invoke(null,(Object) new String[]{"aa","bb"});//加(Object)是为了避免编译器拆分数组
            /*
            【m.invoke(null,new String[]{"aa","bb"});】
            由于可变参数是JDK5.0之后才有的，会被编译成：m.invoke(null,"aa","bb")抛出参数个数不匹配的问题
            因此，m.invoke(null,new String[]{"aa","bb"})相当于调用public static void main("aa","bb")
            但是main方法是一个参数 String[]
            所以会抛出wrong number of arguments异常
            解决办法：加上(Object)转型
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
