package com.zw.annotation.test;

import com.zw.annotation.pojo.Student;
import com.zw.simplify.MyBatisUtils2;
import com.zw.annotation.mapper.StudentMapper;
import com.zw.annotation.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * <p>Title: JavaBasic-com.zw.union.test</p>
 * <p>Description: 测试类</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/27/2020
 */
public class TestAnnotation {
    public static void main(String[] args) {
        MyBatisUtils2.setConfig("mybatis-annotation.xml");
        SqlSession session = MyBatisUtils2.getSession();

        Student student = new Student();
        student.setId(-1);
        student.setName("新同学");
        student.setAge(17);
        student.setTid(1);

//        testAnnotationSel(session);
//        testAnnotationIns(session,student);
//        testAnnotationUpd(session,student);
//        testAnnotationDel(session,student);
        testAnnotationSelN(session);

        session.commit();
        MyBatisUtils2.closeSession();
    }
    /**
     * <p>Description: 查询学生信息（注解方式）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 3:55 PM
     */
    public static void testAnnotationSel(SqlSession session){
        System.out.println("-------查询学生信息（注解方式）-------");
        StudentMapper students = session.getMapper(StudentMapper.class);
        System.out.println(students.selStuByAnno());
    }

    /**
     * <p>Description: 新增学生信息（注解方式）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 4:12 PM
     */
    public static void testAnnotationIns(SqlSession session,Student student){
        System.out.println("-------新增学生信息（注解方式）-------");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        System.out.println(studentMapper.insStuByAnno(student));
    }

    /**
     * <p>Description: 修改学生信息（注解方式）</p>
     *
     * @param session
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/27/2020 4:32 PM
     */
    public static void testAnnotationUpd(SqlSession session,Student student){
        System.out.println("-------修改学生信息（注解方式）-------");
        student.setId(1);
        student.setName("即将转学");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.uptStudByAnno(student));
    }

    /**
     * <p>Description: 删除学生信息（注解方式）</p>
     *
     * @param session
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/27/2020 4:46 PM
     */
    public static void testAnnotationDel(SqlSession session,Student student){
        System.out.println("-------删除学生信息（注解方式）-------");
        student.setId(1);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.delStuByAnno(student));
    }

    /**
     * <p>Description: N+1方式查询学生信息（注解方式）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 4:59 PM
     */
    public static void testAnnotationSelN(SqlSession session){
        System.out.println("-------N+1方式查询学生信息（注解方式）-------");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.selStuByAnnoN());
    }

}
