package org.example.register_products.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.register_products.model.Product;
import org.example.register_products.service.ProductService;
import org.example.register_products.service.ProductServiceImpl;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        productService.register(product);

        response.sendRedirect("pages/mensajeProducto.jsp");
    }

    public void destroy() {
    }
}