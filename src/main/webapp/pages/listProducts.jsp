<%@ page import="org.example.register_products.service.ProductService" %>
<%@ page import="org.example.register_products.service.ProductServiceImpl" %>
<%@ page import="org.example.register_products.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: frontdev
  Date: 3/08/24
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
<link href="https://unpkg.com/nes.css@2.1.0/css/nes.min.css" rel="stylesheet" />
<head>
    <title>Title</title>
</head>
<body>
<div class="todo__container">
    <h1>Producto guardado</h1>
    <div class="nes-table-responsive">
        <table class='nes-table is-bordered is-dark'>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre del producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
            <%
                ProductService productService = new ProductServiceImpl();
                List<Product> products = productService.list();
                for (Product product : products) {
            %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getQuantity() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <button type="button" class="nes-btn is-primary todo-btn__back" id="todo-btn__back">Volver</button>

</div>
<script>
    document.getElementById('todo-btn__back').addEventListener('click', function() {
        window.history.back();
    });
</script>
</body>
</html>
