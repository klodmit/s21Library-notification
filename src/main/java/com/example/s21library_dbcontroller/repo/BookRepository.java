package com.example.s21library_dbcontroller.repo;

import com.example.s21library_dbcontroller.entities.Book;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAll();

    Book findAllByTitleAndAuthor(String title, String author);

    @Override
    void delete(Book entity);

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    <S extends Book> S save(S entity);
}
