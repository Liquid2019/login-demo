package cn.login.web;

import cn.login.domain.User;
import cn.login.service.UserService;
import cn.login.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String real_checkCode = (String)session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(!checkCode.equalsIgnoreCase(real_checkCode)){
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        UserService userService = new UserServiceImpl();
        User login_user = userService.login(user);
        if(login_user==null){
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        else{
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/home.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
