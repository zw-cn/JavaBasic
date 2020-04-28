package com.zw.demo.air;

import com.zw.demo.air.pojo.Airplane;
import com.zw.demo.air.pojo.Airport;
import com.zw.demo.air.service.AirService;
import com.zw.demo.air.service.impl.AirServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>Title: JavaBasic-com.zw.demo.air</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/28/2020
 */
@WebServlet(name="airServlet",urlPatterns = "/air")
public class AirServlet extends HttpServlet {
    private AirService airService = new AirServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String takeIdStr = req.getParameter("takeId");
        String landIdStr = req.getParameter("landId");

        int takeId=0;
        int landId=0;
        if(takeIdStr != null && !"".equals(takeIdStr)){
            takeId = Integer.parseInt(takeIdStr);
        }
        if(landIdStr != null && !"".equals(landIdStr)){
            landId = Integer.parseInt(landIdStr);
        }
        List<Airplane> airplanes = airService.airplanes(takeId, landId);
        req.setAttribute("airplanes",airplanes);

        List<Airport> airports = airService.airports();
        req.setAttribute("airplanes",airplanes);
        req.setAttribute("airports",airports);

        req.getRequestDispatcher("/air/air.jsp").forward(req,resp);
    }
}
