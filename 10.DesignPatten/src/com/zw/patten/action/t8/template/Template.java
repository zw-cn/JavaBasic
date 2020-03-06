package com.zw.patten.action.t8.template;

/**
 * @program: JavaBasic
 * @description: 模板模式
 * @author: zw-cn
 * @create: 2020-03-06 15:22
 */
public class Template {
    public static void main(String[] args) {
        BankTemplate template = new drawMoney();
        template.process();
        //通常使用匿名内部类实现
        BankTemplate template2 = new BankTemplate(){
            @Override
            protected void operation() {
                System.out.println("存钱");
            }
        };
        template2.process();
    }
}
abstract class BankTemplate{
    private void takeANumber(){
        System.out.println("取号");
    }
    protected abstract void operation();
    private void evaluate(){
        System.out.println("评价");
    }
    public final void process(){
        takeANumber();
        operation();
        evaluate();
    }
}
class drawMoney extends BankTemplate{
    @Override
    protected void operation() {
        System.out.println("取钱");
    }
}
