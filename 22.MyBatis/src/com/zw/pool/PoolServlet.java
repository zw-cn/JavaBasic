package com.zw.pool;

import com.zw.traditional.JDBCUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>Title: JavaBasic-com.zw.pool</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/25/2020
 */
@WebServlet(name = "pool",urlPatterns = "/pool")
public class PoolServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        Context cxt = null;
        try {
            cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/testPool");
            Connection conn = ds.getConnection();
            System.out.println("从Tomcat连接池获取连接"+(conn!=null?"成功":"失败"));
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            if(conn!=null){
                String sql = "select * from flower";

                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                resp.setContentType("text/html;charset=utf-8");
                while (rs.next()){
                    resp.getWriter().write(rs.getInt(1)+","+rs.getString(2)+"<br/>");
                }
            }
            JDBCUtils.release(rs,pstmt,conn);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
