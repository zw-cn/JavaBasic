package com.zw.union.mapper;

import com.zw.union.pojo.Student;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.union.mapper</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/27/2020
 */
public interface StudentMapper {
    List<Student> students();
    List<Student> studentsN();
    List<Student> studentsU();
    List<Student> studentsUA();
    Student stuByTid(int tid);

}
