package com.library.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Author {
    @Id
    private Long id;
    private String name;
    private String bio;
}