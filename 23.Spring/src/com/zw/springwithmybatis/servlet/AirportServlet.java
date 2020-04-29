package com.zw.springwithmybatis.servlet;

import com.zw.springwithmybatis.pojo.Airport;
import com.zw.springwithmybatis.service.AirportService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.springwithmybatis.servlet</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
@WebServlet(name = "smAirports",urlPatterns = "/airport")
public class AirportServlet extends HttpServlet {
    private AirportService airportService;
    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        airportService = webApplicationContext.getBean("airportService", AirportService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airports = airportService.airports();
        req.setAttribute("airports",airports);
        req.getRequestDispatcher("air.jsp").forward(req,resp);
    }
}
