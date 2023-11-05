package com.joe.project.reposietpry;

import com.joe.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findById(int id);

    void deleteById(int id);
}
