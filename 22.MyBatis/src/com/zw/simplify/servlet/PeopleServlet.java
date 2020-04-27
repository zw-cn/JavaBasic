package com.zw.simplify.servlet;

import com.zw.simplify.pojo.People;
import com.zw.simplify.service.PeopleService;
import com.zw.simplify.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.simplify.servlet</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/26/2020
 */
@WebServlet(name = "PeopleServlet",urlPatterns = "/people")
public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<People> peopleList = peopleService.showPeople();
        req.setAttribute("pl",peopleList);
        req.getRequestDispatcher("people.jsp").forward(req, resp);
    }
}
