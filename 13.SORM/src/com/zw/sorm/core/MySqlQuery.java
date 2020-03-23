package com.zw.sorm.core;

import com.zw.sorm.po.U_user;
import com.zw.sorm.vo.EmpVO;

import java.sql.Timestamp;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: Mysql查询实现Query接口
 * @author: zw-cn
 * @create: 2020-03-14 15:27
 */
public class MySqlQuery extends Query {
    public static void testQueryRows(){
        MySqlQuery query = new MySqlQuery();
        List list = query.queryRows("select name from u_user where id>? and regDate <?",U_user.class,20,"2020-3-3");
        System.out.println(list);

        System.out.println("测试联合查询");
        query = new MySqlQuery();
        String sql = "select e.id Id,e.name empName,e.salary+e.bonus income,d.name type from u_emp e,u_dept d where e.deptId = d.id";
        list = query.queryRows(sql, EmpVO.class,null);
        System.out.println(list);
    }

    public static void testQueryNumber(){
        MySqlQuery query = new MySqlQuery();
        String sql = "select sum(salary) from u_emp e where e.deptId in (1,2)";
        Number number = query.queryNumber(sql,null);
        System.out.println(number);
    }
    public static void main(String[] args) {
        testQueryNumber();
    }

    public static void testDML() {
        U_user user = new U_user();
        //user.setId(25);
        MySqlQuery query = new MySqlQuery();
        //query.delete(user);
        user.setName("666444");
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        //query.insert(user);
        user.setId(22);
        query.update(user, new String[]{"name", "lastLogin"});
    }

    @Override
    public Object queryPagination(int pageNum, int size) {
        return null;
    }
}
