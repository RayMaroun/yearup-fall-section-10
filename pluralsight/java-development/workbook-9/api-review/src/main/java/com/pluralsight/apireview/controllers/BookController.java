package com.pluralsight.apireview.controllers;

import com.pluralsight.apireview.models.Book;
import com.pluralsight.apireview.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(name = "title", required = false) String title,
                                  @RequestParam(name = "author", required = false) String author,
                                  @RequestParam(name = "year", required = false) Integer publicationYear) {
        return bookService.getAllBooks(title, author, publicationYear);
    }

    //@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    //@RequestMapping(path = "/", method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    //@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    //@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
