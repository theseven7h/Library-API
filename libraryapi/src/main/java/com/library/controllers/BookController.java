package com.library.controllers;

import com.library.data.models.Book;
import com.library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServices bookServices;

    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookServices.addBook(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookServices.getAllBooks());
    }

    @GetMapping(path="{id}")
    public Book getBookById(@PathVariable("id") String bookId) {
        return bookServices.getBookById(bookId);
    }

    @PutMapping(path="{id}")
    public Book updateBook(@PathVariable("id") String bookId, @RequestBody Book book) {
        return bookServices.updateBook(bookId, book);
    }

    @DeleteMapping(path="{id}")
    public void deleteBook(@PathVariable("id") String bookId) {
        bookServices.deleteBook(bookId);
    }
}
