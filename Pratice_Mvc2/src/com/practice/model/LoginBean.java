package com.practice.model;

import com.practice.da.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean {

    private String username,password;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  boolean checkLogin() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String dbUsername = resultSet.getString("username");
        String dbPassword = resultSet.getString("password");


        if (username.equals(dbUsername) && password.equals(dbPassword)){

            return true;
        }else {

            return false;
        }

    }
}
