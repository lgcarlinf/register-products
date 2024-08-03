package org.example.register_products.service;

import org.example.register_products.model.Product;

import java.util.List;

public interface ProductService {
    void register(Product product);
    List<Product> list();
}