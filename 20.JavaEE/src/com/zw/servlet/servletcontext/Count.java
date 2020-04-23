package com.zw.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
public class Count extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext context = this.getServletContext();
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(context.getRealPath("/doc/count/nums.txt")))) {
            count = reader.readLine()==null?0:Integer.valueOf(reader.readLine());
            context.setAttribute("count",count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    
    public void destroy() {
        ServletContext context = this.getServletContext();
        int count = (int)context.getAttribute("count");;
        context.setAttribute("count",count);
        try(FileWriter writer = new FileWriter(context.getRealPath("/doc/count/nums.txt"))){
            writer.write(count);
            System.out.println(count+"写入文件");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
