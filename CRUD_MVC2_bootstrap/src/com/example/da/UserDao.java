package com.example.da;

import com.example.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/t1907m";
    private String jdbcUsername ="root";
    private String jdbcPassword = "";

    private static final String INSERT_USER_SQL = "INSERT INTO user(username,userpassword,country) VALUES(?,?,?)";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String DELETE_USERS_SQL = "DELETE  FROM user WHERE id=?";
    private static final String UPDATE_USERS_SQL = "UPDATE user set username=?,userpassword=?,country=? WHERE id=?";

    public UserDao() {
    }
    protected Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        return connection;
    }
    public static void main(String[] args)throws ClassNotFoundException, SQLException
    {
        UserDao us = new UserDao();
        if (us.getConnection()!=null)
        {
            System.out.println("okoko");
        }
    }

    public void insertUser(User u)throws ClassNotFoundException, SQLException
    {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
        preparedStatement.setString(1,u.getName());
        preparedStatement.setString(2,u.getPassword());
        preparedStatement.setString(3,u.getCountry());
        preparedStatement.executeUpdate();
    }

    public User selectUser(int id) throws ClassNotFoundException, SQLException
    {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next())
        {
            String name = rs.getString("username");
            String pass = rs.getString("userpassword");
            String country = rs.getString("country");
            user = new User(id,name,pass,country);
        }
        return user;
    }

    public List<User> selectAllUsers()throws ClassNotFoundException, SQLException
    {
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("username");
            String pass = rs.getString("userpassword");
            String country = rs.getString("country");
            users.add(new User(id,name,pass,country));
        }
        return users;
    }

    public boolean deleteUser(int id)throws ClassNotFoundException, SQLException
    {
        boolean rowDeleted;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
        statement.setInt(1,id);
        rowDeleted = statement.executeUpdate()>0;

        return rowDeleted;
    }

    public boolean updateUser(User us)throws ClassNotFoundException, SQLException
    {
        boolean rowUpdate;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
        statement.setString(1,us.getName());
        statement.setString(2,us.getPassword());
        statement.setString(3,us.getCountry());
        statement.setInt(4,us.getId());
        rowUpdate = statement.executeUpdate()>0;
        return rowUpdate;
    }
}
