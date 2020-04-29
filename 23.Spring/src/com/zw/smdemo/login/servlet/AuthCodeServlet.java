package com.zw.smdemo.login.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * <p>Title: JavaBasic-com.zw.smdemo.login.service</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/29/2020
 */
@WebServlet("/code")
public class AuthCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        Random random = new Random();
        graphics.setColor(Color.WHITE);
        //背景图
        graphics.fillRect(0, 0, 200, 100);
        //画验证码，设置字体
        graphics.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,40));
        Color[] colors = new Color[]{Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.GRAY};
        var codeList = new ArrayList<>();
        for(int i=0;i<4;i++){
            int temp = random.nextInt(10);
            codeList.add(temp);
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(temp+"",50*i, 70+(random.nextInt(21)-10));
        }
        //画线
        for(int i=0;i<4;i++){
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());

        HttpSession session = req.getSession();
        session.setAttribute("code",codeList.toString().replaceAll("\\D",""));
    }
}
