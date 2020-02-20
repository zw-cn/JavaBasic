package com.zw.reflection;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: Java脚本引擎
 * @author: zw-cn
 * @create: 2020-02-20 13:34
 */
public class Reflection_06_Script {
    public static void main(String[] args) throws Exception{
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义对象到脚本引擎中
        engine.put("Li","Li is a good wife");
        String str = "var user = {name:'Li',age:18,schools:['PKU']};";
        str += "print(user.age);";//使用println会报错"println" is not defined in <eval>

        //执行脚本
        engine.eval(str);
        engine.eval("Li = 'Li is a good student'");
        System.out.println(engine.get("Li"));

        /*java->js*/
        System.out.println("--------java->js--------");
        {
            //js字符串
            {
                //定义函数
                engine.eval("function add(a,b){var sum = a+b; return sum;}");
                //获得调用接口
                Invocable jsInvoke = (Invocable) engine;
                //执行函数
                Object result1 = jsInvoke.invokeFunction("add",new Object[]{19,20});
                System.out.println(result1);
            }
            //js文件
            URL url = Reflection_06_Script.class.getResource("/js/sum.js");
//            engine.eval(new FileReader(url.getPath()));//这样不显示的关闭资源会不会有问题？
            FileReader fr = new FileReader(URLDecoder.decode(url.getPath(),"utf-8"));//由于中文路径，添加URLDecoder转换为utf-8
            engine.eval(fr);
            fr.close();
        }

        /*js->java*/
        System.out.println("--------js->java--------");
        //导入Java的包，使用Java的类
        //String code="importPackage(java.util);var list=Arrays.asList([\"啤酒\",\"饮料\",\"矿泉水\"]);";//jdk1.8以后不适用
        String code="var list=java.util.Arrays.asList([\"啤酒\",\"饮料\",\"矿泉水\"]);";
        engine.eval(code);

        List<String> list2  = (List<String>) engine.get("list");
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
