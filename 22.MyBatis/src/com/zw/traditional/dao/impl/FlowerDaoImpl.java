package com.zw.traditional.dao.impl;

import com.zw.traditional.JDBCUtils;
import com.zw.traditional.dao.FlowerDao;
import com.zw.traditional.pojo.Flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.traditional.dao.impl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/25/2020
 */
public class FlowerDaoImpl implements FlowerDao {
    @Override
    public List<Flower> selAll() {
        List<Flower> fl = new ArrayList<>();
        String sql = "select * from flower";
        ResultSet rs = null;
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()){
                fl.add(new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(rs);
        }
        return fl;
    }

    @Override
    public int addFlower(Flower flower) {
        int result=-1;
        String sql = "insert  into flower values (default ,?,?,?)";
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,flower.getName());
            pstmt.setDouble(2,flower.getPrice());
            pstmt.setString(3,flower.getProduction());
            System.out.println(pstmt);
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
