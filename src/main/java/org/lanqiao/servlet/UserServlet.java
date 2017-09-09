package org.lanqiao.servlet;

import org.lanqiao.service.IUserService;
import org.lanqiao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/8/30.
 */
   @WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {

    @Autowired
    IUserService userService;
    @Override
    public void init() throws ServletException {
        // 启动spring自动注入的支持
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("=============");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了post方法");
        List<User> userList=userService.getAllUser();
        request.setAttribute("users",userList);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
