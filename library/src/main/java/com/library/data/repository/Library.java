package com.library.data.repository;

import com.library.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Library extends JpaRepository<Book, Long> {
}