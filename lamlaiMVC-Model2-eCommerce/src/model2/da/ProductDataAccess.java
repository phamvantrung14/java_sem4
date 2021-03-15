package model2.da;

import model2.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataAccess {
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public PreparedStatement getSearchStatement(String sql) throws SQLException, ClassNotFoundException
    {
        if (preparedStatement==null)
        {
            //3. call connection
            Connection connection = new DBConnection().getConnection();
            //4 create statement
            //preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE pro_name LIKE ?");
            preparedStatement = connection.prepareStatement("SELECT * FROM product "+sql);
        }
        return  preparedStatement;
    }

    public boolean updateProduct(Product pro)
    {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstmt;
        try{
            conn = new DBConnection().getConnection();
            pstmt = conn.prepareStatement("UPDATE product SET pro_name=?,pro_desc=? WHERE id=?");
            pstmt.setString(1,pro.getName());
            pstmt.setString(2,pro.getDesc());
            pstmt.setInt(3,pro.getId());
            int i = pstmt.executeUpdate();
            if(i>0)
            {
                bl=true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return bl;
    }
    public boolean addProduct(Product p)
    {
        boolean bl = false;
        Connection conn;
        PreparedStatement pstmt;

        try{
            conn = new DBConnection().getConnection();
            pstmt = conn.prepareStatement("insert into product(pro_name,pro_desc) values (?,?)");

            pstmt.setString(1,p.getName());
            pstmt.setString(2,p.getDesc());
            int i = pstmt.executeUpdate();
            if (i>0)
            {
                bl = true;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return bl;
    }
    public List<Product> getProductByName(String name) throws SQLException, ClassNotFoundException
    {
        PreparedStatement statement = getSearchStatement("WHERE pro_name LIKE ?");
        //5.Call Result
        statement.setString(1,"%"+name+"%");
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next())
        {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("pro_name"));
            product.setDesc(resultSet.getString("pro_desc"));
            products.add(product);
        }

        return products;
    }

    public List<Product> getProductAll()throws SQLException, ClassNotFoundException
    {
        PreparedStatement statement = getSearchStatement("");
        ResultSet rs = statement.executeQuery();

        List<Product> listProducts = new ArrayList<>();
        while (rs.next())
        {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("pro_name"));
            product.setDesc(rs.getString("pro_desc"));
            listProducts.add(product);
        }

        return listProducts;
    }
    public List<Product> getProductByDesc()throws SQLException, ClassNotFoundException
    {
        PreparedStatement statement = getSearchStatement("ORDER BY pro_name DESC");
        ResultSet rs = statement.executeQuery();
        List<Product> listProducts = new ArrayList<>();
        while (rs.next())
        {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("pro_name"));
            product.setDesc(rs.getString("pro_desc"));
            listProducts.add(product);
        }
        return listProducts;
    }
    public List<Product> getProductByAsc()throws SQLException, ClassNotFoundException
    {
        PreparedStatement statement = getSearchStatement("ORDER BY pro_name");
        ResultSet rs = statement.executeQuery();

        List<Product> listProducts = new ArrayList<>();
        while (rs.next())
        {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("pro_name"));
            product.setDesc(rs.getString("pro_desc"));
            listProducts.add(product);
        }
        return listProducts;
    }

    public Product getProductById(int id)throws SQLException, ClassNotFoundException
    {
        Product product = null;
        PreparedStatement statement = getSearchStatement("WHERE id=?");
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        if (rs.next())
        {
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("pro_name"));
            product.setDesc(rs.getString("pro_desc"));
        }
        return product;
    }

    public boolean deleteProductById(int id_pro)
    {
        boolean bl = true;
        Connection conn;
        PreparedStatement pstmt;
        try{
            conn = new DBConnection().getConnection();
            pstmt = conn.prepareStatement("DELETE  FROM product WHERE id=?");
            pstmt.setInt(1,id_pro);
            int i = pstmt.executeUpdate();
            if(i>0)
            {
                bl = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return bl;
    }




}
