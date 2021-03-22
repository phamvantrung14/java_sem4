package com.example.controller;

import com.example.model.UserFinderBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUser")
public class ServletUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFinderBean userFinderBean = new UserFinderBean();
        String option = request.getParameter("action");
        if(option==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        switch (option)
        {
            case "login":
                loginSession(request,response,userFinderBean);
                break;
            default:
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFinderBean userFinderBean = new UserFinderBean();
        String option = request.getParameter("action");
        if(option==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        switch (option)
        {
            case "logout":
                logoutSession(request,response);
                break;
        }
    }

    public void logoutSession(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        request.getSession().invalidate();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void loginSession(HttpServletRequest request, HttpServletResponse response, UserFinderBean userFinderBean)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            boolean u = userFinderBean.checkLogin(username,password);
            if (u)
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("username",username);
                request.getRequestDispatcher("product/product.jsp").forward(request,response);
            }else {
                request.setAttribute("err","lohin failes");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
