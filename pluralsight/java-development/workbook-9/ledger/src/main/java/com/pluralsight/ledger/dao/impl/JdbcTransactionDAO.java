package com.pluralsight.ledger.dao.impl;

import com.pluralsight.ledger.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledger.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionDAO implements ITransactionDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcTransactionDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        initialize(); // Initialize database tables and data on startup.
    }

    private void initialize() {
        // This method sets up the database table and populates it with initial data if necessary.
        try (Connection connection = dataSource.getConnection()) {
            // SQL statement to create a transactions table if it does not exist.
            String createTableQuery = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "transaction_id INT PRIMARY KEY," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "vendor VARCHAR(255) NOT NULL" +
                    ")";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.execute(); // Execute the table creation query.
            }

            // Check if the table has any data already.
            String countQuery = "SELECT COUNT(*) AS rowCount FROM transactions";
            try (PreparedStatement countStatement = connection.prepareStatement(countQuery);
                 ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt("rowCount") == 0) {
                    // Insert initial data if the table is empty.
                    String insertDataQuery = "INSERT INTO transactions (transaction_id, amount, vendor) VALUES (?, ?, ?)";
                    try (PreparedStatement insertDataStatement = connection.prepareStatement(insertDataQuery)) {
                        // Insert first transaction.
                        insertDataStatement.setInt(1, 1);
                        insertDataStatement.setDouble(2, 2000.00);
                        insertDataStatement.setString(3, "Raymond");
                        insertDataStatement.executeUpdate();

                        // Insert second transaction.
                        insertDataStatement.setInt(1, 2);
                        insertDataStatement.setDouble(2, 2500.00);
                        insertDataStatement.setString(3, "Buba");
                        insertDataStatement.executeUpdate();

                        // Insert third transaction.
                        insertDataStatement.setInt(1, 3);
                        insertDataStatement.setDouble(2, 4000.00);
                        insertDataStatement.setString(3, "Hamza");
                        insertDataStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }

    @Override
    public void add(Transaction transaction) {
        // This method adds a new transaction to the database.
        String insertDataQuery = "INSERT INTO transactions (transaction_id, amount, vendor) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertDataQuery)) {
            // Setting parameters for the insert query.
            insertStatement.setInt(1, transaction.getTransactionId());
            insertStatement.setDouble(2, transaction.getAmount());
            insertStatement.setString(3, transaction.getVendor());
            insertStatement.executeUpdate(); // Execute the insert query.
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        // This method retrieves all transactions from the database.
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM transactions");
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                int transactionId = resultSet.getInt("transaction_id");
                double amount = resultSet.getDouble("amount");
                String vendor = resultSet.getString("vendor");
                // Create a Transaction object and add it to the list.
                transactions.add(new Transaction(transactionId, amount, vendor));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return transactions; // Return the list of transactions.
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        // This method retrieves a specific transaction by its ID.
        Transaction transaction = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM transactions WHERE transaction_id = ?")) {
            selectStatement.setInt(1, transactionId); // Set the ID parameter in the query.
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract data from the result set.
                    double amount = resultSet.getDouble("amount");
                    String vendor = resultSet.getString("vendor");
                    // Create a Transaction object.
                    transaction = new Transaction(transactionId, amount, vendor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return transaction; // Return the found transaction or null.
    }

    @Override
    public void update(Transaction transaction) {
        // This method updates an existing transaction in the database.
        String updateDataQuery = "UPDATE transactions SET amount = ?, vendor = ? WHERE transaction_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateDataQuery)) {
            // Setting parameters for the update query.
            updateStatement.setDouble(1, transaction.getAmount());
            updateStatement.setString(2, transaction.getVendor());
            updateStatement.setInt(3, transaction.getTransactionId());
            updateStatement.executeUpdate(); // Execute the update query.
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }

    @Override
    public void delete(Transaction transaction) {
        // This method deletes a transaction from the database.
        String deleteDataQuery = "DELETE FROM transactions WHERE transaction_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteDataQuery)) {
            deleteStatement.setInt(1, transaction.getTransactionId()); // Set the ID parameter in the delete query.
            deleteStatement.executeUpdate(); // Execute the delete query.
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }
}
