package com.learning.springbootrest.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findByBookId(long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()) {
            return book.get();
        }
        return new Book();
    }
    
    public void saveBook(Book book) {
        if(book != null) {
            bookRepository.save(book);
        }
    }
    
    public void updateBook(Book paramBook) {
        Optional<Book> book = bookRepository.findById(paramBook.getBookId());
        if(book.isPresent()) {
            saveBook(paramBook);
        }
    }

    public void deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
    }
}
