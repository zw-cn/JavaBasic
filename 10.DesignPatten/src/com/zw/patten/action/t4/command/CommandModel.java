package com.zw.patten.action.t4.command;

/**
 * @program: JavaBasic
 * @description: 命令模式
 * @author: zw-cn
 * @create: 2020-03-06 13:32
 */
public class CommandModel {
    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
interface Command{
    void execute();
}
class ConcreteCommand implements Command{
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
class Receiver{
    public void action(){
        System.out.println("Receiver.action");
    }
}
class Invoker{
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void call(){
        System.out.println("执行命令前");
        command.execute();
        System.out.println("执行命令后");
    }
}