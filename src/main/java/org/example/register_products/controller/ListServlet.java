package org.example.register_products.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.register_products.service.ProductService;
import org.example.register_products.service.ProductServiceImpl;

import java.io.IOException;

@WebServlet(name = "ListServlet", value = "/product-list")
public class ListServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><link href=\"https://fonts.googleapis.com/css?family=Press+Start+2P\" rel=\"stylesheet\">\n" +
                "    <link href=\"https://unpkg.com/nes.css@2.3.0/css/nes.min.css\" rel=\"stylesheet\" /><body>");
        response.getWriter().println("<div class='todo__container'>");
        response.getWriter().println("<h1>Products</h1>");
        response.getWriter().println("<ul>");
        response.getWriter().println("<div class=\"nes-table-responsive\">");
        response.getWriter().println( "<table class='nes-table is-bordered is-dark'><thead>");
        response.getWriter().println("<tr>\n" +"   <th>Id</th>");
        response.getWriter().println("\n" +"<th>Nombre del producto</th>");
        response.getWriter().println("\n" +"<th>Precio</th>");
        response.getWriter().println("  <th>Cantidad</th>\n" +" </tr>");
        response.getWriter().println("  </thead>\n" + "    <tbody>");
        productService.list().forEach(product -> {
            try {
                response.getWriter().println(" <tr>\n" +"<td>" + product.getId() + " </td> \n"+"<td>" + product.getName() + " </td> \n" +"<td>" + product.getPrice() + " </td> \n" + "<td>" + product.getQuantity() + " </td> \n" );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        response.getWriter().println("</tbody>\n" +"  </table>\n" +"</div>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body></html>");
    }
}