package db;

import models.CustomerOrderHistory;
import models.SalesByCategory;
import models.SalesByYear;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private BasicDataSource dataSource;

    public DataManager(String url, String username, String password) {
        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL CustOrderHist(?)}")) {
            statement.setString(1, customerId);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String productName = resultSet.getString("ProductName");
                    int totalQuantity = resultSet.getInt("Total");

                    CustomerOrderHistory orderHistory = new CustomerOrderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);
                }
            }
        } catch (SQLException e) {
        }

        return orderHistoryList;
    }

    public List<SalesByYear> searchSalesByYear(String beginningDate, String endingDate) {
        List<SalesByYear> salesByYearList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL `Sales by Year`(?, ?)}")) {
            Date startDate = Date.valueOf(beginningDate);
            Date endDate = Date.valueOf(endingDate);

            statement.setDate(1, startDate);
            statement.setDate(2, endDate);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Date shippedDate = resultSet.getDate("ShippedDate");
                    int orderID = resultSet.getInt("OrderID");
                    double subtotal = resultSet.getDouble("Subtotal");
                    int year = resultSet.getInt("Year");

                    SalesByYear salesByYear = new SalesByYear(shippedDate, orderID, subtotal, year);
                    salesByYearList.add(salesByYear);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salesByYearList;
    }


    public List<SalesByCategory> searchSalesByCategory(String categoryName, String year) {
        List<SalesByCategory> salesByCategoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL SalesByCategory(?, ?)}")) {
            statement.setString(1, categoryName);
            statement.setString(2, year);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String productName = resultSet.getString("ProductName");
                    double totalPurchase = resultSet.getDouble("TotalPurchase");

                    SalesByCategory salesByCategory = new SalesByCategory(productName, totalPurchase);
                    salesByCategoryList.add(salesByCategory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salesByCategoryList;
    }
}

