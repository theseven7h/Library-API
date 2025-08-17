package com.library.services;

import com.library.data.models.Author;
import com.library.data.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {
    private final AuthorRepository authorRepository;

    public AuthorServices(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(String authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() ->  new IllegalStateException("Author with id " + authorId + " not found"));
    }

    public Author updateAuthor(String authorId, Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (optionalAuthor.isEmpty()) {
            throw new IllegalStateException("Author with id " + authorId + " not found");
        }
//        deleteAuthorById(authorId);
        authorRepository.deleteById(authorId);
        return authorRepository.save(author);
    }

    public void deleteAuthorById(String authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isEmpty()) {
            throw new IllegalStateException("Author with id " + authorId + " not found");
        }
        authorRepository.deleteById(authorId);
    }
}