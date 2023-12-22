package com.pluralsight.apireview.dao.impl;

import com.pluralsight.apireview.dao.interfaces.IBookDAO;
import com.pluralsight.apireview.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDAO implements IBookDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcBookDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> getAllBooks(String title, String author, Integer publicationYear) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM Books " +
                "WHERE (title = ? OR ? = '') " +
                " AND (author = ? OR ? = '') " +
                " And (publication_year = ? OR ? = -1) ";

        title = title == null ? "" : title;
        author = author == null ? "" : author;
        publicationYear = publicationYear == null ? -1 : publicationYear;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, author);
            preparedStatement.setInt(5, publicationYear);
            preparedStatement.setInt(6, publicationYear);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Book book = extractBookFromResultSet(resultSet);
                    books.add(book);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getBookById(int id) {
        String query = "SELECT * FROM Books WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Book book = extractBookFromResultSet(resultSet);
                    return book;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book insertBook(Book book) {
        String query = "INSERT INTO Books (title, author, publication_year) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPublicationYear());

            int rows = preparedStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Insert failed, no rows affected!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    book.setId(generatedId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public void updateBook(int id, Book book) {
        String query = "UPDATE Books SET title = ?, author = ?, publication_year = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPublicationYear());
            preparedStatement.setInt(4, id);

            int rows = preparedStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Update failed, no rows affected!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        String query = "DELETE FROM Books WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Delete failed, no rows affected!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Book extractBookFromResultSet(ResultSet resultSet) throws SQLException {
        int idFromDB = resultSet.getInt("id");
        String titleFromDB = resultSet.getString("title");
        String authorFromDB = resultSet.getString("author");
        int yearFromDB = resultSet.getInt("publication_year");
        return new Book(idFromDB, titleFromDB, authorFromDB, yearFromDB);
    }
}
