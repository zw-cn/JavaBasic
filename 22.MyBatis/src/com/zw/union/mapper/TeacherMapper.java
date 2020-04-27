package com.zw.union.mapper;

import com.zw.union.pojo.Teacher;

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
public interface TeacherMapper {
    List<Teacher> teachersN();
    List<Teacher> teachersU();
    Teacher selById(int id);
}
