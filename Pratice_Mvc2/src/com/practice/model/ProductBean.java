package com.practice.model;

import com.practice.da.CreateDataAccess;
import com.practice.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBean {



    public List<Product> getProducts() throws SQLException, ClassNotFoundException {
        return new CreateDataAccess().getAllProduct();
    }
}
