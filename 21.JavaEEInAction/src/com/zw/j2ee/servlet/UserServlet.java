package com.zw.j2ee.servlet;

import com.zw.j2ee.pojo.User;
import com.zw.j2ee.service.UserService;
import com.zw.j2ee.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * <p>Title: JavaBasic-${PACKAGE_NAME}</p>
 * <p>Description: ${Description}</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/23/2020
 */
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    //声明日志对象
    Logger logger =Logger.getLogger(UserServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取操做符
        String oper=req.getParameter("oper");
        if("login".equals(oper)){
            //调用登录处理方法
            checkUserLogin(req,resp);
        }else if("out".equals(oper)){
            //调用退出功能
            userOut(req,resp);
        }else if("pwd".equals(oper)){
            //调用密码修改功能
            userChangePwd(req,resp);
        }else if("show".equals(oper)){
            //调用显示所有用户功能
            userShow(req,resp);
        }else if("reg".equals(oper)){
            //调用注册功能
            userReg(req,resp);
        }else{
            logger.debug("没有找到对应的操作符："+oper);
        }

    }

    /**
     * <p>Description: 处理用户登录</p>
     *
     * @param req
     * @param resp
     * @return void
     * @throws
     * @author zw-cn
     * @date: 4/23/2020 12:52 PM
     */
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        User user = userService.checkUserLoginService(uname, pwd);
        //校验登录
        if (user != null) {
            //成功
            //获取session对象
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //重定向
            resp.sendRedirect("/JavaEEInAction/main/main.jsp");
            return;
        } else {
            //失败
            req.setAttribute("flag", 0);
            //转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
    }
    /**
     * <p>Description: 用户注册</p>
     *
     * @param req
     * @param resp
     * @return void
     * @throws IOException
     * @author zw-cn
     * @date: 4/23/2020 2:00 PM
     */
    private void userReg(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String sex=req.getParameter("sex");
        int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
        String birth=req.getParameter("birth");
        String[] bs=null;
        if(birth!=""){
            bs=birth.split("/");
            birth=bs[2]+"-"+bs[0]+"-"+bs[1];
        }
        logger.debug(uname+":"+pwd+":"+sex+":"+age+":"+birth);
        User u=new User(0, uname, pwd, sex, age, Date.valueOf(birth));
        //处理请求信息
        //调用业务层处理
        int index=userService.userRegService(u);
        //响应处理结果
        if(index>0){
            //获取session
            HttpSession hs=req.getSession();
            hs.setAttribute("reg", "true");
            //重定向
            resp.sendRedirect("/JavaEEInAction/login.jsp");
        }
    }

    /**
     * <p>Description: 显示所有的用户信息</p>
     *
     * @param req
     * @param resp
     * @return void
     * @author zw-cn
     * @date: 4/23/2020 2:01 PM
     */
    private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求
        //调用service
        List<User> lu=userService.userShowService();
        //判断
        if(lu!=null){
            //将查询的用户数据存储到request对象
            req.setAttribute("lu",lu);
            //请求转发
            req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
            return;
        }

    }

    /**
     * <p>Description: 用户修改密码</p>
     *
     * @param req
     * @param resp
     * @return void 
     * @author zw-cn
     * @date: 4/23/2020 2:03 PM
     */
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        String newPwd=req.getParameter("newPwd");
        //从session中获取用户信息
        User u=(User)req.getSession().getAttribute("user");
        int uid=u.getUid();
        //处理请求
        //调用service处理
        int index=userService.userChangePwdService(uid,newPwd);
        if(index>0){
            //获取session对象
            HttpSession hs=req.getSession();
            hs.setAttribute("pwd","true");
            //重定向到登录页面
            resp.sendRedirect("/JavaEEInAction/login.jsp");
        }
    }

    /**
     * <p>Description: 用户退出</p>
     *
     * @param req
     * @param resp
     * @return void 
     * @author zw-cn
     * @date: 4/23/2020 2:03 PM
     */
    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession hs=req.getSession();
        //强制销毁session
        hs.invalidate();
        //重定向到登录页面
        resp.sendRedirect("/JavaEEInAction/login.jsp");
    }
}
