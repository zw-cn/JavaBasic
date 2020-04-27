package com.zw.annotation.mapper;

import com.zw.annotation.pojo.Student;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from student")
    List<Student> selStuByAnno();

    @Insert("insert into student values(default,#{name},#{age},#{tid})")
    int insStuByAnno(Student student);

    @Update("update student set name = #{name},age=#{age},tid=#{tid} where id=#{id}")
    int uptStudByAnno(Student student);

    @Delete("delete from student where id = #{id}")
    int delStuByAnno(Student student);


    @Results(
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "name",column = "name"),
                    @Result(property = "age",column = "age"),
                    @Result(property = "tid",column = "tid"),
                    @Result(property = "teacher",column = "tid",one = @One(select = "com.zw.annotation.mapper.TeacherMapper.selById"))
            }
    )
    @Select("select * from student")
    List<Student> selStuByAnnoN();

}
