package com.pluralsight.NorthwindTradersSpringBoot4.dao.impl;


import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements IProductDao {

    private final DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
        initialize();
    }

    private void initialize() {
        try (Connection connection = dataSource.getConnection()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS products (" +
                    "product_id INT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "category VARCHAR(255) NOT NULL," +
                    "price DECIMAL(10, 2) NOT NULL" +
                    ")";

            try (PreparedStatement createTableStmt = connection.prepareStatement(createTableQuery)) {
                createTableStmt.execute();
            }


            String countQuery = "SELECT COUNT(*) AS rowcount FROM products";
            try (PreparedStatement countStmt = connection.prepareStatement(countQuery);
                 ResultSet resultSet = countStmt.executeQuery()) {
                if (resultSet.next() && resultSet.getInt("rowcount") == 0) {

                    String insertDataQuery = "INSERT INTO products (product_id, name, category, price) " +
                            "VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertDataStmt = connection.prepareStatement(insertDataQuery)) {

                        insertDataStmt.setInt(1, 1);
                        insertDataStmt.setString(2, "Product 1");
                        insertDataStmt.setString(3, "Category 1");
                        insertDataStmt.setDouble(4, 10.0);
                        insertDataStmt.executeUpdate();

                        insertDataStmt.setInt(1, 2);
                        insertDataStmt.setString(2, "Product 2");
                        insertDataStmt.setString(3, "Category 2");
                        insertDataStmt.setDouble(4, 20.0);
                        insertDataStmt.executeUpdate();

                        insertDataStmt.setInt(1, 3);
                        insertDataStmt.setString(2, "Product 3");
                        insertDataStmt.setString(3, "Category 3");
                        insertDataStmt.setDouble(4, 30.0);
                        insertDataStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String insertQuery = "INSERT INTO products (product_id, name, category, price) " +
                    "VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, product.getProductId());
                insertStmt.setString(2, product.getName());
                insertStmt.setString(3, product.getCategory());
                insertStmt.setDouble(4, product.getPrice());
                insertStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String selectQuery = "SELECT product_id, name, category, price FROM products";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {
                while (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    double price = resultSet.getDouble("price");
                    Product product = new Product(productId, name, category, price);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        try (Connection connection = dataSource.getConnection()) {
            String selectQuery = "SELECT product_id, name, category, price FROM products WHERE product_id = ?";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, productId);
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String category = resultSet.getString("category");
                        double price = resultSet.getDouble("price");
                        return new Product(productId, name, category, price);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String updateQuery = "UPDATE products SET name = ?, category = ?, price = ? WHERE product_id = ?";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                updateStmt.setString(1, product.getName());
                updateStmt.setString(2, product.getCategory());
                updateStmt.setDouble(3, product.getPrice());
                updateStmt.setInt(4, product.getProductId());
                updateStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String deleteQuery = "DELETE FROM products WHERE product_id = ?";
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                deleteStmt.setInt(1, product.getProductId());
                deleteStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}