package com.zw.thread;

/**
 * @description: 管程法：使用管程解决死锁
 *              1.使用wait()方法
 * @author: zw-cn
 * @create: 2020-02-03 15:27
 */
public class Test_06_DeadLockHandel_01 {
    public static void main(String[] args) {
        Data[] dataBuffer = new Data[20];
        Buffer buffer = new Buffer(dataBuffer);
        new Thread(new Producers(buffer)).start();
        new Thread(new Consumers(buffer)).start();
    }
}

/**
 * @description: 生产者
 * @author: zw-cn
 * @create: 2020/2/3 15:30
 */
class Producers implements Runnable {
    Buffer buffer;

    public Producers(Buffer buffer) {
        this.buffer = buffer;
    }

    public void product() {
        Data newData;
        for (int i = 0; i < 80; i++) {
            newData = new Data("data-" + i);
            buffer.push(newData);
            System.out.println("create data " + newData.name);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            product();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * @description: 消费者
 * @author: zw-cn
 * @create: 2020/2/3 15:33
 */
class Consumers implements Runnable {
    Buffer buffer;

    public Consumers(Buffer buffer) {
        this.buffer = buffer;
    }

    public void consume() {
        Data oldData;
        for (int i = 0; i < 200; i++) {
            oldData = buffer.pop();
            System.out.println("using data:" + oldData.name);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(400);
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * @description: 数据
 * @author: zw-cn
 * @create: 2020/2/3 15:34
 */
class Data {
    String name;

    public Data(String name) {
        this.name = name;
    }
}

/**
 * @description: 缓冲仓库
 * @author: zw-cn
 * @create: 2020/2/3 15:35
 */
class Buffer {
    Data[] datas;
    int size;

    public Buffer(Data[] datas) {
        this.datas = datas;
    }

    /**
     * @param data
     * @description: 生产线程调用方法
     * @return: void
     * @author: zw-cn
     * @time: 2020/2/3 16:02
     */
    public synchronized void push(Data data) {
        while (datas.length == size) {//数据已满
            try {
                System.out.println("正在等待消费数据...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        datas[size++] = data;
        this.notify();
    }

    public synchronized Data pop() {
        while (size == 0) {
            try {
                System.out.println("正在等待生产数据...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return datas[--size];
    }
}