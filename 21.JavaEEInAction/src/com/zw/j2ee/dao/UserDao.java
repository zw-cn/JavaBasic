package com.zw.j2ee.dao;

import com.zw.j2ee.pojo.User;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.j2ee.dao</p>
 * <p>Description: 用户DAO操作接口</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/23/2020
 */
public interface UserDao {
    /**
     * <p>Description: 查询用户信息</p>
     *
     * @param uname
     * @param pwd
     * @return com.zw.j2ee.pojo.User 
     * @author zw-cn
     * @date: 4/23/2020 12:15 PM
     */
    User checkUserLoginDao(String uname,String pwd);

    /**
     * <p>Description: 根据UID更改用户密码</p>
     *
     * @param uid 用户ID
     * @param newPwd 新密码
     * @return int 
     * @author zw-cn
     * @date: 4/23/2020 12:16 PM
     */
    int userChangePwdDao(int uid,String newPwd);
    /**
     * <p>Description: 查询所有用户信息</p>
     *
     * @return java.util.List<com.zw.j2ee.pojo.User>
     * @author zw-cn
     * @date: 4/23/2020 12:17 PM
     */
    List<User> userShowDao();
    /**
     * <p>Description: 用户注册</p>
     *
     * @param user
     * @return int 
     * @throws 
     * @author zw-cn
     * @date: 4/23/2020 12:18 PM
     */
    int userRegDao(User user);
}
