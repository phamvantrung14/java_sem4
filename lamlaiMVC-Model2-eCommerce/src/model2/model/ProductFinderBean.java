package model2.model;

import model2.da.ProductDataAccess;
import model2.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductFinderBean {

    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Product> getProductByName()throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().getProductByName(keyword);
    }
    public List<Product> getProductAll()throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().getProductAll();
    }
    public List<Product> getProductByDesc() throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().getProductByDesc();
    }
    public List<Product> getProductByAsc()throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().getProductByAsc();
    }
    public Product getProductById(int id)throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().getProductById(id);
    }
    public boolean insertProduct(Product product)throws SQLException, ClassNotFoundException{
        return new ProductDataAccess().addProduct(product);
    }
    public boolean deleteProductById(int id)throws SQLException, ClassNotFoundException
    {
        return  new ProductDataAccess().deleteProductById(id);
    }
    public  boolean updateProduct(Product p)throws SQLException, ClassNotFoundException
    {
        return new ProductDataAccess().updateProduct(p);
    }
}
