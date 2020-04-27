package com.zw.limit.servlet;

import com.zw.limit.pojo.PageInfo;
import com.zw.limit.service.LimitFlowerService;
import com.zw.limit.service.impl.LimitFlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title: JavaBasic-${PACKAGE_NAME}</p>
 * <p>Description: ${Description}</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
@WebServlet(name = "page",urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    private LimitFlowerService pageService = new LimitFlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String pageNumberStr = req.getParameter("pageNumber");
        String pageSizeStr = req.getParameter("pageSize");
        int pageNumber=1;
        int pageSize=2;
        if (pageNumberStr!=null && !pageNumberStr.equals("")){
             pageNumber = Integer.valueOf(pageNumberStr);
        }
        if (pageSizeStr!=null && !pageSizeStr.equals("")){
            pageSize = Integer.valueOf(pageSizeStr);
        }
        PageInfo pageInfo = pageService.pageFlowers(pageNumber, pageSize);
        if (pageInfo != null){
            req.setAttribute("pageInfo",pageInfo);
            req.getRequestDispatcher("/page/page.jsp").forward(req,resp);
            return;
        }
    }
}
