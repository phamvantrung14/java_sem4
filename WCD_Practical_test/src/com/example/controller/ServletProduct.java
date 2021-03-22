package com.example.controller;

import com.example.model.ProductFinderBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProduct")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductFinderBean finderBean = new ProductFinderBean();
        getAllProduct(request,response,finderBean);
    }


    public void getAllProduct(HttpServletRequest request, HttpServletResponse response, ProductFinderBean finderBean)
    {
        try{
            request.setAttribute("finder",finderBean);
            request.getRequestDispatcher("product/product.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
