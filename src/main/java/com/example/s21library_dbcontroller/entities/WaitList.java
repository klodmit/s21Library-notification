package com.example.s21library_dbcontroller.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "waitList")
public class WaitList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_visitor")
    private Long visitorId;
    @Column(name = "id_book")
    private Long bookId;
    @Column(name = "date_reserve")
    private Date reserveDate;
    @Column(name = "date_period")
    private Date periodDate;
}
