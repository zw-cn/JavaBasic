package com.zw.patten.struct.t1.adapter;

/**
 * @program: JavaBasic
 * @description: 适配器模式
 * @author: zw-cn
 * @create: 2020-03-02 10:35
 */
public class Adapter {
    public static void main(String[] args) {
        System.out.println("目标：让猪说话");

        System.out.println("使用组合方式（推荐）");
        Pig pig = new Pig();
        PigAdapter adapter = new PigAdapter(pig);
        adapter.speak();

        System.out.println("使用继承方式");
        PigAdapter2 adapter2 = new PigAdapter2();
        adapter2.speak();
    }
}
interface Target{
    void speak();
}
/**
 * @description: 使用组合方式
 * @author: zw-cn
 * @create: 3/2/2020 10:54 AM
 */
class PigAdapter implements Target{
    private Pig pig;

    public PigAdapter(Pig pig) {
        this.pig = pig;
    }

    @Override
    public void speak() {
        pig.mumble();
    }
}
/**
 * @description: 使用继承方式
 * @author: zw-cn
 * @create: 3/2/2020 10:55 AM
 */
class PigAdapter2 extends Pig implements Target{
    @Override
    public void speak() {
        super.mumble();
    }
}
class Pig{
    String name;
    public void mumble(){
        System.out.println("ke~ke~");
    }
}