package com.pluralsight.db;

import com.pluralsight.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String productsQuery = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productsQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                double unitPrice = resultSet.getDouble(3);
                int unitsInStock = resultSet.getInt(4);

                Product product = new Product(productId, productName, unitPrice, unitsInStock);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }


    public Product getProductById(int productId) {
        String productByIdQuery = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products WHERE ProductID = ?";
        Product product = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productByIdQuery)) {
            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int productIdFromDb = resultSet.getInt(1);
                    String productName = resultSet.getString(2);
                    double unitPrice = resultSet.getDouble(3);
                    int unitsInStock = resultSet.getInt(4);

                    product = new Product(productIdFromDb, productName, unitPrice, unitsInStock);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
