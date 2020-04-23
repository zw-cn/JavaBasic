package com.zw.servlet.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * <p>Title: JavaBasic-${PACKAGE_NAME}</p>
 * <p>Description: ${Description}</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/21/2020
 */
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取用户信息
        String u_name = req.getParameter("u_name");
        String u_password = req.getParameter("u_password");
        //数据库校验（跳过）
        if(u_name.equals("张三") && u_password.equals("1234")){
            //创建cookie
            Cookie c = new Cookie("uid","1");
            c.setMaxAge(3*24*3600);
//        c.setPath();
            HttpSession session = req.getSession();
            session.setAttribute("user", new String("张三，1234"));
            session.setMaxInactiveInterval(30);
            resp.addCookie(c);
            ServletContext servletContext = this.getServletContext();
            int count = (int) servletContext.getAttribute("count");
            servletContext.setAttribute("count",++count);
            resp.sendRedirect("myIndex");
        }else{
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("myLoginPage").forward(req,resp);
        }

    }
}
