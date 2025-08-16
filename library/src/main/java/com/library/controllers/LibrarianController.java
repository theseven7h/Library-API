package com.library.controllers;

import com.library.data.model.Book;
import com.library.services.LibrarianServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibrarianController {
    private final LibrarianServices librarianServices;

    @Autowired
    public LibrarianController(LibrarianServices librarianServices) {
        this.librarianServices = librarianServices;
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        librarianServices.addNewBook(book);
    }

    @GetMapping
    public List<Book> getStudents() {
        return librarianServices.findAllBooks();
    }

    @GetMapping(path = "{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId) {
        return librarianServices.findBookById(bookId);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
        librarianServices.updateBook(book, bookId);
    }


}
