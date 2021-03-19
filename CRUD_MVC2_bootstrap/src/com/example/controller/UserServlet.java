package com.example.controller;

import com.example.da.UserDao;
import com.example.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "/us")
public class UserServlet extends HttpServlet {
    private UserDao userDao;
    public void init(){userDao = new UserDao();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try{
            switch (action)
            {
                case "/new":
                    showNewForm(request,response);
                    break;
                case "/insert":
                    insertUser(request,response);
                    break;
                case "/delete":
                    deleteUser(request,response);
                    break;
                case "/edit":
                    showEditForm(request,response);
                    break;
                case "/update":
                    updateUser(request,response);
                    break;
                default:
                    listUser(request,response);
                    break;
            }



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        List<User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user",existingUser);
        dispatcher.forward(request,response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String country = request.getParameter("country");
        User newUser = new User(name,pass,country);
        userDao.insertUser(newUser);
        response.sendRedirect("list");
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String country = request.getParameter("country");
        User book = new User(id,name,pass,country);
        userDao.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException,SQLException,IOException,ClassNotFoundException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("list");
    }
}
