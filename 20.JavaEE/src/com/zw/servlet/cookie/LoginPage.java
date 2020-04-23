package com.zw.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
public class LoginPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>欢迎登陆");
        out.write("</title>");
        out.write("</head>");
        out.write("<body>");
        out.write(req.getAttribute("msg")==null?"":"<span style='color:red;font-size:20px'>"+req.getAttribute("msg")+"</span>");
        out.write("<form action='myLogin' method='post'>");
        out.write("用户名：<input type='text' name='u_name'>");
        out.write("<br/>");
        out.write("密码：<input type='password' name='u_password'>");
        out.write("<input type='submit' value='提交'>");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");
    }
}
