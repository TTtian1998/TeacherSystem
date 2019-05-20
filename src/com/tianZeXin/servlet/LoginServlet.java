package com.tianZeXin.servlet;

import com.tianZeXin.controller.UserController;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 田泽鑫
 * @date 2019/5/12
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    UserController userController = new UserController();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("用户名:"+username+"密码:"+password);

        boolean result =userController.login(username,password);
        response.getWriter().append(result+"");
        if (result){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doGet(request,response);
    }
}
