package com.library.controllers;

import com.library.data.models.Author;
import com.library.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {
    private final AuthorServices authorServices;

    @Autowired
    public AuthorController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    @PostMapping
    public ResponseEntity<Author> addNewAuthor(Author author) {
//        return authorServices.addAuthor(author);
        return ResponseEntity.ok(authorServices.addAuthor(author));
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorServices.getAllAuthors();
    }

    @GetMapping(path="{id}")
    public Author getAuthor(@PathVariable("id") String authorId) {
        return authorServices.getAuthorById(authorId);
    }

    @PutMapping(path="/{id}")
    public Author updateAuthor(@PathVariable("id") String authorId, @RequestParam Author author) {
        return authorServices.updateAuthor(authorId, author);
    }

    @DeleteMapping(path="{id}")
    public void deleteAuthor(@PathVariable("id") String authorId) {
        authorServices.deleteAuthorById(authorId);
    }
}
