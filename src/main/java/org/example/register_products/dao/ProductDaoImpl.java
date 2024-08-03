package org.example.register_products.dao;

import jakarta.servlet.annotation.WebServlet;
import org.example.register_products.model.Product;
import org.example.register_products.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection connection;

    public ProductDaoImpl() {
        this.connection = Connect.getConnection();
    }

    @Override
    public void register(Product product) {
        String sql = "INSERT INTO Product (name, price, quantity) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error registering product", e);
        }
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error listing products", e);
        }
        return products;
    }

}
