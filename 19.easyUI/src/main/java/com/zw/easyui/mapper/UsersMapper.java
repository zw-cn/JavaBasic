package com.zw.easyui.mapper;

import com.zw.easyui.pojo.Users;
import org.apache.ibatis.annotations.Select;

/**
 * <p>Title: JavaBasic-com.zw.easyui.mapper</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/17/2020
 */
public interface UsersMapper {
    @Select("select * from users where name=#{name} and password=#{password}")
    Users selByUsers(Users users);
}
