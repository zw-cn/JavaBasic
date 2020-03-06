package com.zw.patten.action.t1.chainofresponsibility;

/**
 * @program: JavaBasic
 * @description: 责任链模式
 * @author: zw-cn
 * @create: 2020-03-05 15:19
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest("Tom",9,"Catch mouse");
        Leader l1 = new Director("Tom's Father");
        Leader l2 = new Manager("Tom's Mother");
        Leader l3 = new ViceGeneralManager("Tom's wife");
        Leader l4 = new GeneralManager("Tom's boss");
        l1.setNextLeader(l2);
        l2.setNextLeader(l3);
        l3.setNextLeader(l4);
        l1.handleRequest(request);
    }
}
/**
 * @description: 请假单
 * @author: zw-cn
 * @create: 3/5/2020 3:22 PM
 */
class LeaveRequest{
    private String name;
    private int days;
    private String reason;

    public LeaveRequest(String name, int days, String reason) {
        this.name = name;
        this.days = days;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "name='" + name + '\'' +
                ", days=" + days +
                ", reason='" + reason + '\'' +
                '}';
    }
}
abstract class Leader{
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }
    public abstract void handleRequest(LeaveRequest request);
}
class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays() < 5){
            System.out.println(request);
            System.out.println(name+"主管，审批通过");
        }else{
            if (nextLeader != null){
                nextLeader.handleRequest(request);
            }
        }
    }
}
class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays() < 10){
            System.out.println(request);
            System.out.println(name+"经理，审批通过");
        }else{
            if (nextLeader != null){
                nextLeader.handleRequest(request);
            }
        }
    }
}
class ViceGeneralManager extends Leader{

    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays() < 20){
            System.out.println(request);
            System.out.println(name+"副总经理，审批通过");
        }else{
            if (nextLeader != null){
                nextLeader.handleRequest(request);
            }
        }
    }
}
class GeneralManager extends Leader{

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays() < 30){
            System.out.println(request);
            System.out.println(name+"总经理，审批通过");
        }else{
            System.out.println("这是怎么个情况？");
        }
    }
}
