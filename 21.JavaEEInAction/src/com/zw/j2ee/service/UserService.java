package com.zw.j2ee.service;

import com.zw.j2ee.pojo.User;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.j2ee.service</p>
 * <p>Description: 用户服务</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/23/2020
 */
public interface UserService {
    /**
     * <p>Description: 用户登录</p>
     *
     * @param uname 用户名
     * @param pwd 密码
     * @return User 返回查询到的用户信息
     * @author zw-cn
     * @date: 4/23/2020 12:04 PM
     */
    User checkUserLoginService(String uname, String pwd);
    /**
     * <p>Description: 修改用户密码</p>
     *
     * @param uid 用户ID
     * @param newPwd 新密码
     * @return int 
     * @throws 
     * @author zw-cn
     * @date: 4/23/2020 12:06 PM
     */
    int userChangePwdService(int uid,String newPwd);

    /***
     * <p>Description: 查询所有用户信息</p>
     *
     * @return List<User> 所有用户信息列表
     * @author zw-cn
     * @date: 4/23/2020 12:08 PM
     */
    List<User> userShowService();

    /**
     * <p>Description: 用户注册</p>
     *
     * @param user 用户信息
     * @return int 
     * @throws 
     * @author zw-cn
     * @date: 4/23/2020 12:08 PM
     */
    int userRegService(User user);
}
