package model2.controller;

import model2.da.ProductDataAccess;
import model2.entity.Product;
import model2.model.ProductFinderBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionValue = request.getParameter("action");
        ProductFinderBean finderBean = new ProductFinderBean();
        if(actionValue.equals("save"))
        {
            Product p = new Product();
            p.setName(request.getParameter("name"));
            p.setDesc(request.getParameter("desc"));
            try{
            boolean bl = finderBean.insertProduct(p);
                if (bl)
                {
                    List<Product> productList = finderBean.getProductAll();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("product/addProduct.jsp").forward(request,response);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }else if(actionValue.equals("delete"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                boolean bl = finderBean.deleteProductById(id);
                if(bl)
                {
                    List<Product> productList = finderBean.getProductAll();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }else{
                    Product product = finderBean.getProductById(id);
                    request.setAttribute("product",product);
                    request.getRequestDispatcher("productDetail.jsp").forward(request,response);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }else if(actionValue.equals("editProduct")){
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                Product product = finderBean.getProductById(id);
                request.setAttribute("product",product);
                request.getRequestDispatcher("editProduct.jsp").forward(request,response);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }else if(actionValue.equals("update"))
        {
            Product p = new Product();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setName(request.getParameter("name"));
            p.setDesc(request.getParameter("desc"));
            try{
                boolean bl = finderBean.updateProduct(p);
                if(bl)
                {
                    List<Product> productList = finderBean.getProductAll();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }else{
                    Product product = finderBean.getProductById(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("product",product);
                    request.getRequestDispatcher("editProduct.jsp").forward(request,response);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywordData = (request.getParameter("name")!=null)?request.getParameter("name"):"";
        int sortDesc = (request.getParameter("status")!= null) ? Integer.parseInt(request.getParameter("status")):0;
        int id = (request.getParameter("id")!= null) ? Integer.parseInt(request.getParameter("id")):0;
        ProductFinderBean finderBean = new ProductFinderBean();
        finderBean.setKeyword(keywordData);
        try
        {
            if(keywordData.trim().isEmpty())
            {
                if(sortDesc==1)
                {
                    List<Product> productList = finderBean.getProductByDesc();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }else if(sortDesc==2)
                {
                    List<Product> productList = finderBean.getProductByAsc();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }else if(id!=0)
                {
                    Product product = finderBean.getProductById(id);
                    request.setAttribute("product",product);
                    request.getRequestDispatcher("productDetail.jsp").forward(request,response);
                }
                else{
                    List<Product> productList = finderBean.getProductAll();
                    request.setAttribute("list",productList);
                    request.getRequestDispatcher("product.jsp").forward(request,response);
                }
            }
            else{
                List<Product> productList = finderBean.getProductByName();
                request.setAttribute("list",productList);
                request.getRequestDispatcher("product.jsp").forward(request,response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
