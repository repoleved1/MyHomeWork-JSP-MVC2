package com.practice.controller;

import com.practice.da.CreateDataAccess;
import com.practice.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateController")
public class CreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String desc = request.getParameter("desc");
            Product product = new Product(Integer.parseInt(id),name,desc);
//            product.setId(Integer.parseInt(id));
//            product.setName(name);
//            product.setDesc(desc);

        try {

            CreateDataAccess createDataAccess = new CreateDataAccess();
            createDataAccess.createProduct(product);
            response.sendRedirect("display.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
