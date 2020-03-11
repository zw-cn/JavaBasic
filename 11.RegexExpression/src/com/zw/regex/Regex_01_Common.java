package com.zw.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: JavaBasic
 * @description: 正则表达式基本操作
 * @author: zw-cn
 * @create: 2020-03-09 14:09
 */
public class Regex_01_Common {
    public static void main(String[] args) {
        testGroup();//正则表达式的基本使用
        testLookahead();//环视



    }
    public static void testNormal(){

    }

    public static void testGroup(){
        Pattern pattern = Pattern.compile("\\d(\\d(\\w))");//组的顺序（左->右）的括号分别为1-N组

        //匹配器
        Matcher matcher = pattern.matcher("123abc#998887sss");
        System.out.println(matcher.matches());
        matcher.reset();
        while (matcher.find()){
            System.out.println(matcher.group());//子串
            System.out.println(matcher.group(0));//捕获组=子串
            System.out.println(matcher.group(1));//捕获组1
            System.out.println(matcher.group(2));//捕获组2
        }
    }

    /**
     * 预搜索（零宽断言）
     * ->(?=exp)    断言自身出现的位置的后面能匹配表达式exp
     * ->(?<=exp)    断言自身出现的位置的前面能匹配表达式exp
     * ->(?!exp)    断言此位置的后面不能匹配表达式exp
     * ->(?<!exp)    断言此位置的前面不能匹配表达式exp
     */
    public static void testLookahead() {
        System.out.println("*****环视*****");
        String target = "000 100# #101 #102# 103#104 200@ @201@ 202@203 @300@#";
        matchRegex("\\d{3}(?=#)", target);//3位数字后边挨着#的
        matchRegex("(?<=#)\\d{3}", target);//前面有#,挨着的3位数字
        matchRegex("\\d{3}(?!@)", target);//3位数字后面不是接着@的
        matchRegex("(?<!@)\\d{3}", target);//3位数字前面接着@的

        /*
         * FIXME 以下2个不知如何翻译
         *  目前的观点：断言后边的位置往前找，前边的位置往后找->其实没什么用,都是它自己
         */
        matchRegex("\\d+(?<!@)", target);
        matchRegex("(?!@)\\d+", target);
    }

    /**
     * @param pattenString
     * @param target
     * @description: 根据模式和匹配字符串获取匹配结果（group(0)）
     * @return: void
     * @author: zw-cn
     * @time: 3/10/2020 8:36 AM
     */
    public static void matchRegex(String pattenString, String target) {
        matchRegex(pattenString, target, 0);
    }

    /**
     * @param pattenString
     * @param target
     * @param group
     * @description: 根据模式和匹配字符串获取匹配结果
     * @return: void
     * @author: zw-cn
     * @time: 3/10/2020 8:53 AM
     */
    public static void matchRegex(String pattenString, String target, int group) {
        //正则对象
        Pattern pattern = Pattern.compile(pattenString);
        //匹配器对象
        Matcher matcher = pattern.matcher(target);
        System.out.println(matcher.find() ? target + "->" + pattenString + "=>成功" : "失败");
        //重置匹配器-位置
        matcher.reset();
        while (matcher.find()) {
            for (int i = 0; i <= group; i++) {
                System.out.println("Group_" + i + "->" + matcher.group(group));
            }
        }
    }

}
