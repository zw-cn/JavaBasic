package com.zw.smdemo.login.servlet;

import com.zw.smdemo.login.pojo.User;
import com.zw.smdemo.login.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title: JavaBasic-com.zw.smdemo.login.servlet</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = context.getBean("userService",UserService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        String code = req.getParameter("code");
        User u = new User();
        u.setUname(uname);
        u.setUpassword(upassword);
        User user = userService.userCheck(u);
        if(!code.equals(req.getSession().getAttribute("code"))){
            req.setAttribute("error","验证码错误！");
            req.getRequestDispatcher("/code/login.jsp").forward(req,resp);
            return;
        }
        if (user == null){
            req.setAttribute("error","用户名、密码错误！");
            req.getRequestDispatcher("/code/login.jsp").forward(req,resp);
            return;
        }else {
            resp.sendRedirect("/Spring/code/main.jsp");
        }
    }
}
