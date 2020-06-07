package com.practice.da;

import com.practice.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CreateDataAccess {

    public void createProduct(Product p) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES(?,?,?) ");
        preparedStatement.setInt(1,p.getId());
        preparedStatement.setString(2,p.getName());
        preparedStatement.setString(3,p.getDesc());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM product");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> products = new LinkedList<>();
        while (resultSet.next()){
            products.add(new Product(resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("pro_desc")));
        }
        return products;

    }
}
