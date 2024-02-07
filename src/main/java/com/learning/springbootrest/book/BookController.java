package com.learning.springbootrest.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Nonnull;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getMethodName() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        return bookService.findByBookId(bookId);
    }

    @DeleteMapping("/book/{bookId}")
    public void removeBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/book")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody @Nonnull Book book) {
        bookService.saveBook(book);
    }
}
