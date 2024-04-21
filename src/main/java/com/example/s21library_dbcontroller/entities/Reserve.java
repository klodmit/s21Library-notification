package com.example.s21library_dbcontroller.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reserve")
public class Reserve {
    @Id
    @Column(name = "date_took")
    private LocalDateTime dateTook;
    @Column(name = "date_returned")
    private LocalDateTime dateReturned;
    @Column(name = "id_visitor")
    private Long visitorId;
    @Column(name = "id_book")
    private Long bookId;
    private short activeInd;
    private short deletedInd;
    @PrePersist
    public void prePersist() {
        if (dateTook == null) {
            dateTook = LocalDateTime.now();
        }
    }
}
