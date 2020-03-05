package com.zw.patten.struct.t5.decorator;

/**
 * @program: JavaBasic
 * @description: 装饰模式
 * @author: zw-cn
 * @create: 2020-03-04 21:17
 */
public class Decorator {
    public static void main(String[] args) {
        ConcreteComponent real = new ConcreteComponent();
        Component c = new DecoratorComponentB(new DecoratorComponentA(real));
        c.operation();
    }
}
interface Component{
    void operation();
}
class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("真实角色");
    }
}
class DecoratorComponent implements Component{
    protected Component realComponent;

    public DecoratorComponent(Component realComponent) {
        this.realComponent = realComponent;
    }

    @Override
    public void operation() {

    }
}
class DecoratorComponentA extends DecoratorComponent{

    public DecoratorComponentA(Component realComponent) {
        super(realComponent);
    }

    @Override
    public void operation() {
        realComponent.operation();
        System.out.println("DecoratorComponentA.operation");
    }
}
class DecoratorComponentB extends DecoratorComponent{

    public DecoratorComponentB(Component realComponent) {
        super(realComponent);
    }

    @Override
    public void operation() {
        realComponent.operation();
        System.out.println("DecoratorComponentB.operation");
    }
}