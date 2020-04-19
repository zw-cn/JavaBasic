package com.zw.easyui.service.impl;

import com.zw.easyui.mapper.UsersMapper;
import com.zw.easyui.pojo.Users;
import com.zw.easyui.service.UsersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>Title: JavaBasic-com.zw.easyui.service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/17/2020
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    public Users login(Users users) {
        return usersMapper.selByUsers(users);
    }
}
