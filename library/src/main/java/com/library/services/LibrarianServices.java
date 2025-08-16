package com.library.services;

import com.library.data.model.Book;
import com.library.data.repository.Library;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServices {
    private final Library library;

    @Autowired
    public LibrarianServices(Library library) {
        this.library = library;
    }

    public List<Book> findAllBooks() {
        return library.findAll();
    }

    public Book findBookById(Long id) {
        return library.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        ("Book with id " + id + " not found"));
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = library.findById(book.getId());
        if (bookOptional.isPresent()) {
            throw new IllegalArgumentException
                    ("Book already exists");
        }
        library.save(book);
    }

    @Transactional
    public void updateBook(Book book, Long id) {
        Optional<Book> bookOptional = library.findById(id);
        if (bookOptional.isEmpty()) {
            throw new IllegalArgumentException
                    ("Book with id " + id + " not found");
        }
        library.save(book);
    }
}
