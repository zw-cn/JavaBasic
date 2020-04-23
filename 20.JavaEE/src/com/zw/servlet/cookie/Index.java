package com.zw.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class Index extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null){
            resp.sendRedirect("myCookieCheck");
            return;
        }
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>欢迎进入");
        out.write("</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("欢迎,"+user+"进入主页");
        out.write("共"+this.getServletContext().getAttribute("count")+"人登录过本站！");
        out.write("<form action='myShow' method='get'>");
        out.write("<input type='submit' value='显示个人信息'>");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");
    }
}
