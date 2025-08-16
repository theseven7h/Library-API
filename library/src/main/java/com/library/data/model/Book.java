package com.library.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table
public class Book {
    @Id
    private Long id;
    private String title;
    private String genre;
    private LocalDate yearPublished;
    private Long author_id;
}