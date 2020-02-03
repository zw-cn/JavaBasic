package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: 信号灯法：解决同步问题
 * @author: zw-cn
 * @create: 2020-02-03 18:28
 */
public class Test_06_DeadLockHandel_02 {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Cooker cooker = new Cooker(desk);
        Diners diners = new Diners(desk);
        cooker.start();
        diners.start();
    }
}
/**
 * @description: 厨师类
 * @author: zw-cn
 * @create: 2020/2/3 20:00
 */
class Cooker extends Thread{
    Desk desk;

    public Cooker(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 == 0){
                desk.meal = "菜品"+i/2;
            }else{
                desk.meal = "饮品"+i/2;
            }
            desk.cook();
        }
    }
}
/**
 * @description: 食客类
 * @author: zw-cn
 * @create: 2020/2/3 20:01
 */
class Diners extends Thread{
    Desk desk;

    public Diners(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            desk.eat();
        }
    }
}
/**
 * @description: 餐桌类
 * @author: zw-cn
 * @create: 2020/2/3 20:01
 */
class Desk{
    String meal;
    boolean eatable;//true 食客可以使用，false 厨师可以使用
    public synchronized void cook(){
        if (eatable) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("制作"+meal);
        this.notifyAll();
        eatable = !eatable;
        System.out.println(eatable);
    }
    public synchronized void eat(){
        if (!eatable) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("享用"+meal);
        this.notifyAll();
        eatable = !eatable;
        System.out.println(eatable);
    }
}