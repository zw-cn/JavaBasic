package com.zw.smdemo.login.mapper;

import com.zw.smdemo.login.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * <p>Title: JavaBasic-com.zw.smdemo.login.mapper</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public interface UserMapper {
    @Select("select * from user where uname=#{uname} and upassword=#{upassword}")
    User getUser(User user);
}
