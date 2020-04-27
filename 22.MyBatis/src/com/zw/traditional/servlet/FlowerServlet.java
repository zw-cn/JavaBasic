package com.zw.traditional.servlet;

import com.zw.traditional.service.FlowerService;
import com.zw.traditional.service.impl.FlowerServiceImpl;

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
 * @date 4/25/2020
 */
@WebServlet(name="flowers",urlPatterns = "/flowers")
public class FlowerServlet extends HttpServlet {
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flowers",flowerService.showAll());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
