package cn.login.web;

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
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //创建一对象，在内存中图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        /*
        美化
        2.1填充背景色
        */
        Graphics g=image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);
        //2.3写验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random ran=new Random();
        String checkCode="";
        for (int i = 0; i < 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            checkCode+=ch;
            g.drawString(ch+"",width/5*i,height/2);
        }

        HttpSession session = request.getSession();
        session.setAttribute("checkCode",checkCode);

        //2.4画干扰线
        for (int i = 0; i <4 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
