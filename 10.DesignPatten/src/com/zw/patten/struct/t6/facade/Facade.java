package com.zw.patten.struct.t6.facade;

/**
 * @program: JavaBasic
 * @description: 外观模式
 * @author: zw-cn
 * @create: 2020-03-04 23:16
 */
public class Facade {
    public static void main(String[] args) {
        RegisterProxy creat = new RegisterProxy();
        creat.regist();
    }
}
class RegisterProxy{
    public void regist(){
        BusinessAgency agency = new BJBusinessAgency();
        QualityAgency agency1 = new HDQualityAgency();
        Bank bank = new ICBCBank();
        TaxAgency agency2 = new HDTaxAgency();
        agency.checkName("AAA");
        agency1.checkQuality();
        bank.crateAccount();
        agency2.payTax(100);
    }
}
interface BusinessAgency{
    void checkName(String name);
}
class BJBusinessAgency implements BusinessAgency{
    @Override
    public void checkName(String name) {
        System.out.println("BJBusinessAgency.checkName");
    }
}
interface QualityAgency{
    void checkQuality();
}
class HDQualityAgency implements QualityAgency{
    @Override
    public void checkQuality() {
        System.out.println("HDQualityAgency.checkQuality");
    }
}
interface Bank{
    void crateAccount();
}
class ICBCBank implements Bank{
    @Override
    public void crateAccount() {
        System.out.println("ICBCBank.crateAccount");
    }
}
interface TaxAgency{
    void payTax(int money);
}
class HDTaxAgency implements TaxAgency{
    @Override
    public void payTax(int money) {
        System.out.println("HDTaxAgency.payTax");
    }
}