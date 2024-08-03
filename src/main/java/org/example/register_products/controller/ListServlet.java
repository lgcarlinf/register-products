package org.example.register_products.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.register_products.model.Product;
import org.example.register_products.service.ProductService;
import org.example.register_products.service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/product-list")
public class ListServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> products = productService.list();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listProducts.jsp");
        dispatcher.forward(request, response);
    }
}