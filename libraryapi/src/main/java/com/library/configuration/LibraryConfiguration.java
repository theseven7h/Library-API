package com.library.configuration;

import com.library.data.models.Author;
import com.library.data.models.Book;
import com.library.data.repository.AuthorRepository;
import com.library.data.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository,  BookRepository bookRepository) {
        return args -> {
            authorRepository.deleteAll();
            bookRepository.deleteAll();
            Author author = new Author();
            author.setName("john");
            author.setBio("i am a man");
            Author savedAuthor = authorRepository.save(author);
            for (int i = 1; i <= 10; i++) {
                Book book = new Book();
                book.setAuthorId(savedAuthor);
                book.setTitle("Java");
                book.setGenre("fiction");
                bookRepository.save(book);
            }
        };
    }
}
