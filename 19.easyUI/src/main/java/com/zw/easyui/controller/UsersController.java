package com.zw.easyui.controller;

import com.zw.easyui.pojo.Users;
import com.zw.easyui.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>Title: JavaBasic-com.zw.easyui.controller</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/17/2020
 */
public class UsersController {
    @Resource
    private UsersService usersService;
    @RequestMapping("login")
    public String login(Users users){
        System.out.println("AAAAAAAAA");
        Users user = usersService.login(users);
        return String.valueOf(user!=null?1:0);
    }
}
