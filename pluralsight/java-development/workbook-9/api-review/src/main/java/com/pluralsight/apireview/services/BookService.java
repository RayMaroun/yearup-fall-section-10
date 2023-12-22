package com.pluralsight.apireview.services;

import com.pluralsight.apireview.dao.interfaces.IBookDAO;
import com.pluralsight.apireview.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    private IBookDAO bookDAO;

    @Autowired
    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllBooks(String title, String author, Integer publicationYear) {
        return bookDAO.getAllBooks(title, author, publicationYear);
    }

    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public Book insertBook(Book book) {
        return bookDAO.insertBook(book);
    }

    public void updateBook(int id, Book book) {
        bookDAO.updateBook(id, book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
