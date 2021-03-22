package com.example.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccess {
    private PreparedStatement preparedStatement = null;
    private final String CHECK_USER = "SELECT * FROM tbuser WHERE username=? AND password=?";

    public PreparedStatement loginStatement()throws SQLException, ClassNotFoundException
    {
        if(preparedStatement==null)
        {
            Connection connection = new DBConnection().getConnection();
            preparedStatement = connection.prepareStatement(CHECK_USER);
        }
        return  preparedStatement;
    }

    public boolean checkLoginUser(String username,String pass)throws SQLException, ClassNotFoundException
    {
        boolean bl = false;
        PreparedStatement statement = loginStatement();
        statement.setString(1,username);
        statement.setString(2,pass);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
        {
            bl = true;
        }
        return bl;
    }
}
