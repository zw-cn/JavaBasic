package com.zw.j2ee.dao.impl;

import com.zw.j2ee.dao.UserDao;
import com.zw.j2ee.pojo.User;
import com.zw.j2ee.utils.JDBCUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.j2ee.dao.impl</p>
 * <p>Description: 用户DAO操作实现</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/23/2020
 */
public class UserDaoImpl implements UserDao {
    private Logger log = Logger.getLogger(UserDaoImpl.class);
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        ResultSet rs = null;
        User user = null;
        String sql = "select * from t_user where uname=? and pwd=?";
        try(    Connection conn = JDBCUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
            ){
            pstmt.setString(1,uname);
            pstmt.setObject(2,pwd);


            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(rs);
        }
        return user;
    }

    @Override
    public int userChangePwdDao(int uid, String newPwd) {
        int rs = -1;
        String sql = "update t_user set pwd=? where uid=?";
        try(    Connection conn = JDBCUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setObject(1,newPwd);
            pstmt.setObject(2,uid);
            log.debug(pstmt);
            rs = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }
        return rs;
    }

    @Override
    public List<User> userShowDao() {
        ResultSet rs = null;
        User user = null;
        List<User> userList= new ArrayList<>();
        String sql = "select * from t_user";
        try(    Connection conn = JDBCUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(rs);
        }
        return userList;
    }

    @Override
    public int userRegDao(User user) {
        int rs=-1;
        String sql = "insert into t_user(uid, uname, pwd, sex, age, birth)\n" +
                "VALUES (default, ?, ?, ?, ?, ?)";
        try(    Connection conn = JDBCUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setObject(1,user.getUname());
            pstmt.setObject(2,user.getPwd());
            pstmt.setObject(3,user.getSex());
            pstmt.setObject(4,user.getAge());
            pstmt.setObject(5,user.getBirth());
            rs = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }
        return rs;
    }
}
