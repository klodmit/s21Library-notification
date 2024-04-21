package com.example.s21library_dbcontroller.repo;

import com.example.s21library_dbcontroller.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Override
    <S extends Reserve> S save(S entity);


    Reserve findByBookIdAndVisitorId(Long bookId, Long visitorId);


}
