package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    public static Connection getConnection()throws ClassNotFoundException, SQLException
    {
        if(connection==null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1907m_practical","root","");
        }
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        if (getConnection()!=null)
        {
            System.out.println("oke");
        }
    }
}
