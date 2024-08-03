package org.example.register_products.dao;

import java.util.List;
import org.example.register_products.model.Product;

public interface ProductDao {
    void register(Product product);
    List<Product> list();
}
