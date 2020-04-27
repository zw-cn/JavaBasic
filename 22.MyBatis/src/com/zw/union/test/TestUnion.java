package com.zw.union.test;

import com.zw.simplify.MyBatisUtils;
import com.zw.simplify.MyBatisUtils2;
import com.zw.union.mapper.StudentMapper;
import com.zw.union.mapper.TeacherMapper;
import com.zw.union.pojo.Student;
import com.zw.union.pojo.Teacher;
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
public class TestUnion {
    public static void main(String[] args) {
        MyBatisUtils2.setConfig("mybatis-union.xml");
        SqlSession session = MyBatisUtils2.getSession();

        testResultMap(session);
        testStudentN(session);
        testTeacherN(session);
        testUnionStudent(session);
        testUnionTeacher(session);
        testUnionStudentAutoMapping(session);

        MyBatisUtils2.closeSession();
    }
    /**
     * <p>Description: 测试别名</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 3:55 PM
     */
    public static void testResultMap(SqlSession session){
        System.out.println("-------查询学生信息（别名方式）-------");
        StudentMapper students = session.getMapper(StudentMapper.class);
        System.out.println(students.students());
    }

    /**
     * <p>Description: 查询学生及其老师（N+1方式）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 4:12 PM
     */
    public static void testStudentN(SqlSession session){
        System.out.println("-------查询学生及其老师（N+1方式）-------");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.studentsN());
    }

    /**
     * <p>Description: 查询老师及其学生（N+1方式）</p>
     *
     * @param session
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/27/2020 4:32 PM
     */
    public static void testTeacherN(SqlSession session){
        System.out.println("-------查询老师及其学生（N+1方式）-------");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.teachersN());
    }

    /**
     * <p>Description: 查询学生及其老师（联合查询方式）</p>
     *
     * @param session
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/27/2020 4:46 PM
     */
    public static void testUnionStudent(SqlSession session){
        System.out.println("-------查询学生及其老师（联合查询方式）-------");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.studentsU());
    }

    /**
     * <p>Description: 查询老师及其学生（联合查询方式）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 4:59 PM
     */
    public static void testUnionTeacher(SqlSession session){
        System.out.println("-------查询老师及其学生（联合查询方式）-------");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        System.out.println(teacherMapper.teachersU());
    }

    /**
     * <p>Description: 查询学生及其老师（联合查询方式,自动映射）</p>
     *
     * @param session
     * @return void 
     * @throws 
     * @author zw-cn
     * @date: 4/27/2020 5:03 PM
     */
    public static void testUnionStudentAutoMapping(SqlSession session){
        System.out.println("-------查询学生及其老师（联合查询方式,自动映射）-------");
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.studentsU());
    }


}
