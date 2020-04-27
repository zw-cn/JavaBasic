package com.zw.traditional.servlet;

import com.zw.traditional.pojo.Flower;
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
@WebServlet(name = "addFlower",urlPatterns = "/add")
public class addFlower extends HttpServlet {
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        String production = req.getParameter("production");

        Flower flower = new Flower(-1,name,price,production);
        int result = flowerService.addFlower(flower);
        if (result > 0){
            resp.sendRedirect("index.jsp");
        }else{
            resp.sendRedirect("add.jsp");
        }
    }
}
