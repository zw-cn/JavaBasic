package com.zw.smdemo.login.service.impl;

import com.zw.smdemo.login.mapper.UserMapper;
import com.zw.smdemo.login.pojo.User;
import com.zw.smdemo.login.service.UserService;

/**
 * <p>Title: JavaBasic-com.zw.smdemo.login.service.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Override
    public User userCheck(User user) {
        return userMapper.getUser(user);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
