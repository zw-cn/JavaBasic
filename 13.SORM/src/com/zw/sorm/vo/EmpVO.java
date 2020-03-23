package com.zw.sorm.vo;

/**
 * @program: JavaBasic
 * @description: Emp查询结果对象
 * @author: zw-cn
 * @create: 2020-03-15 23:04
 */
public class EmpVO {
    private Integer id;
    private String empName;
    private Double income;
    private String type;

    public EmpVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", income=" + income +
                ", type='" + type + '\'' +
                '}';
    }
}
