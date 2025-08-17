package com.library.services;

import com.library.data.models.Book;
import com.library.data.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " not found"));
    }

    public Book updateBook(String bookId, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new IllegalStateException("Book with id " + bookId + " not found");
        }
        bookRepository.deleteById(bookId);
        return bookRepository.save(book);
    }

    public void deleteBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new IllegalStateException("Book with id " + bookId + " not found");
        }
        bookRepository.delete(optionalBook.get());
    }
}