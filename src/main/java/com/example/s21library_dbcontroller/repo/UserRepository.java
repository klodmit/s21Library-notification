package com.example.s21library_dbcontroller.repo;

import com.example.s21library_dbcontroller.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Visitor, Long> {
    @Override
    <S extends Visitor> S save(S entity);

    Optional<Visitor> findByChatId(String chatId);
}
