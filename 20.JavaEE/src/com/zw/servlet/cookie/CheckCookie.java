package com.zw.servlet.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class CheckCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应格式
        resp.setContentType("text/html;charset=utf-8");
        //获取Cookie信息
        String uid="";
        if (req.getCookies() != null) {
            List<Cookie> cookieList = Arrays.asList(req.getCookies());
            if(cookieList != null){
                for (Cookie cookie : cookieList) {
                    if (cookie.getName().equals("uid")){
                        uid = cookie.getValue();
                    }
                }
            }
        }
        //处理逻辑信息
        if (uid.equals("") || req.getSession().getAttribute("user")==null){
            req.getRequestDispatcher("myLoginPage").forward(req,resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user", new String("张三，1234"));
            session.setMaxInactiveInterval(30);
            resp.sendRedirect("myIndex");
            ServletContext servletContext = this.getServletContext();
            int count = (int) servletContext.getAttribute("count");
            servletContext.setAttribute("count",++count);
        }
    }
}
