package com.example.da;

import com.example.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataAccess {
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    private final String GET_ALL_PRODUCT = "SELECT * FROM tbproducts";
    public PreparedStatement getAllProductStaement()throws SQLException, ClassNotFoundException
    {
        if(preparedStatement==null)
        {
            Connection connection = new DBConnection().getConnection();
            preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
        }
        return  preparedStatement;
    }

    public List<Product> getAllProduct()throws SQLException, ClassNotFoundException
    {
        PreparedStatement statement = getAllProductStaement();
        ResultSet rs = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next())
        {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setAmount(rs.getFloat("amount"));
            product.setPrice(rs.getFloat("price"));
            product.setDetails(rs.getString("details"));
            products.add(product);
        }
        return products;
    }

}
