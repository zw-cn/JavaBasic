package com.zw.annotation.mapper;

import com.zw.union.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from teacher where id = #{0}")
    Teacher selById(int id);
}
