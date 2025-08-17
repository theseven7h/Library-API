package com.library.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String title;
    @DBRef
    private Author authorId;
    private String genre;
    private LocalDate yearPublished;

    public Book() {
        yearPublished = LocalDate.now();
    }
}
