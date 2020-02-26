package com.zw.jvm;

/**
 * @program: JavaBasic
 * @description: 上下文类加载器
 * @author: zw-cn
 * @create: 2020-02-26 08:51
 */
public class ContextClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ContextClassLoader.class.getClassLoader();
        System.out.println(loader);

        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);
        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("./9.Annotation"));
        System.out.println(Thread.currentThread().getContextClassLoader());//使用了自定义类加载器

        Class<EncryptUtil> c = (Class<EncryptUtil>) Thread.currentThread().getContextClassLoader().loadClass("com.zw.jvm.EncryptUtil");
        System.out.println(c);
        System.out.println(c.getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83->因为FileSystemClassLoader代码中有双亲委派
    }
}
