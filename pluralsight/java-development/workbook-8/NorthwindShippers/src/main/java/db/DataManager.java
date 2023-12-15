package db;

import models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void insertShipper(String companyName, String phoneNumber) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO shippers (ShipperId, CompanyName, Phone) VALUES (11, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, companyName);
            statement.setString(2, phoneNumber);
            statement.executeUpdate();


            try (ResultSet generatedKeys = statement.getGeneratedKeys();) {
                if (generatedKeys.next()) {
                    int shipperId = generatedKeys.getInt(1);
                    System.out.println("New Shipper ID: " + shipperId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM shippers");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int shipperId = resultSet.getInt("ShipperID");
                String companyName = resultSet.getString("CompanyName");
                String phoneNumber = resultSet.getString("Phone");

                Shipper shipper = new Shipper(shipperId, companyName, phoneNumber);
                shippers.add(shipper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shippers;
    }

    public void updateShipperPhoneNumber(int shipperId, String phoneNumber) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE shippers SET Phone = ? WHERE ShipperID = ?")) {
            statement.setString(1, phoneNumber);
            statement.setInt(2, shipperId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteShipper(int shipperId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM shippers WHERE ShipperID = ?")) {
            statement.setInt(1, shipperId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

