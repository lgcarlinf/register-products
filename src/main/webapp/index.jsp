<%@ page import="org.example.register_products.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
    <link href="https://unpkg.com/nes.css@2.3.0/css/nes.min.css" rel="stylesheet" />
    <title>TODO APP</title>
</head>
<body>
    <div class="todo__container">
        <h1>Registre su Producto</h1>
        <div class="todo nes-container is-rounded">
            <form class="todo__form" action="product-servlet" method="post">
                <div class="todo__inputs">
                    <input type="text" name="name" class="todo__inputs--name nes-input" placeholder="Ingresa el nombre del producto">
                    <input type="number" name="quantity" class="todo__inputs--quantity nes-input" placeholder="Ingresa la cantidad">
                    <input type="number" name="price" step="0.01" class="todo__inputs--price nes-input" placeholder="Ingresa el precio">
                </div>
                <button type="submit" class="todo__add nes-btn is-primary">Add</button>
            </form>
        </div>
        <a class="" href="/product-list">Listar Productos</a>
    </div>
</body>
</html>