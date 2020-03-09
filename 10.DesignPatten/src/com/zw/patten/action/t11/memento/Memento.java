package com.zw.patten.action.t11.memento;

import java.util.Stack;

/**
 * @program: JavaBasic
 * @description: 备忘录模式
 * @author: zw-cn
 * @create: 2020-03-09 10:21
 */
public class Memento {
    public static void main(String[] args) {
        Emp emp = new Emp(16,"Xiao Ming",16.88);
        careTaker taker = new careTaker();
        taker.addMemento(emp.createMemento());//添加备忘
        System.out.println(emp.toString());

        emp.setId(30);
        emp.setName("Xiao Li");
        emp.setSalary(900);
        emp.toString();
        System.out.println(emp.toString());

        //恢复
        emp.recovery(taker.getMemento());
        System.out.println(emp.toString());
    }
}
class Emp{
    private int id;
    private String name;
    private double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    //添加备忘
    public EmpMemento createMemento(){
        return new EmpMemento(this);
    }
    //恢复
    public void recovery(EmpMemento memento){
        this.id = memento.getId();
        this.name = memento.getName();
        this.salary = memento.getSalary();
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class EmpMemento{
    private int id;
    private String name;
    private double salary;

    public EmpMemento(Emp emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.salary = emp.getSalary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class careTaker{
    private Stack<EmpMemento> stack;

    public careTaker() {
        stack = new Stack<>();
    }
    public void addMemento(EmpMemento memento){
        stack.push(memento);
    }
    public EmpMemento getMemento(){
        return stack.pop();
    }
}