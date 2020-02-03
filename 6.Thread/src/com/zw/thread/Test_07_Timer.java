package com.zw.thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: JavaBasic
 * @description: 定时器
 * @author: zw-cn
 * @create: 2020-02-03 21:31
 */
public class Test_07_Timer {
    public static void main(String[] args) {
        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 1000);//1秒后执行
//        timer.schedule(new MyTask(), 3000, 10000);//3秒后执行，然后每10秒执行一次
        Calendar cal = new GregorianCalendar(2020,1,3,21,30);
        System.out.println(cal.getTime().toString());
        timer.schedule(new MyTask(), cal.getTime());//定时运行：2020年2月3日 21点30分
        timer.schedule(new MyTask(), cal.getTime(),2000);//定时运行：2020年2月3日 21点30分，启动，每2秒再执行一次
    }

}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("运行定时器任务");
    }
}
