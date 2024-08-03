package org.example.register_products.service;

import org.example.register_products.dao.ProductDao;
import org.example.register_products.dao.ProductDaoImpl;
import org.example.register_products.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void register(Product product) {
        productDao.register(product);
    }

    @Override
    public List<Product> list() {
        return productDao.list();
    }
}
