package com.example.model;

import com.example.da.UserDataAccess;

import java.sql.SQLException;

public class UserFinderBean {
    public boolean checkLogin(String username,String pass)throws SQLException, ClassNotFoundException
    {
        return new UserDataAccess().checkLoginUser(username,pass);
    }
}
