package com.zw.patten.struct.t3.bridge;

/**
 * @program: JavaBasic
 * @description: 桥接模式
 * @author: zw-cn
 * @create: 2020-03-03 11:33
 */
public class Bridge {
    public static void main(String[] args) {
        Bridge_Computer c = new Bridge_Pad(new Lenovo());
        System.out.println(c.toString());
    }
}
/**
 * @description: 计算机父类
 * 为防止被实例化，改为抽象类
 * @author: zw-cn
 * @create: 3/3/2020 5:41 PM
 */
abstract class Bridge_Computer{
    protected Brand brand;

    public Bridge_Computer(Brand brand) {
        this.brand = brand;
    }

}
class Bridge_Pad extends Bridge_Computer{


    public Bridge_Pad(Brand brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return brand.brand()+",Bridge_Pad";
    }
}
class Bridge_Laptop extends Bridge_Computer{

    public Bridge_Laptop(Brand brand) {
        super(brand);
    }
}
interface Brand{
    String brand();
}
class Lenovo implements Brand{

    @Override
    public String brand() {
        return "Lenovo.brand";
    }
}
class Dell implements Brand{
    @Override
    public String brand() {
        return "Dell.brand";
    }
}
class Hasee implements Brand{
    @Override
    public String brand() {
        return "Hasee.brand";
    }
}