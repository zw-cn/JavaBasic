package com.zw.j2ee.service.impl;

import com.zw.j2ee.dao.UserDao;
import com.zw.j2ee.dao.impl.UserDaoImpl;
import com.zw.j2ee.pojo.User;
import com.zw.j2ee.service.UserService;

import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.j2ee.service.impl</p>
 * <p>Description: 用户服务实现</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/23/2020
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        return userDao.checkUserLoginDao(uname,pwd);
    }

    @Override
    public int userChangePwdService(int uid, String newPwd) {
        return userDao.userChangePwdDao(uid,newPwd);
    }

    @Override
    public List<User> userShowService() {
        return userDao.userShowDao();
    }

    @Override
    public int userRegService(User user) {
        return userDao.userRegDao(user);
    }
}
