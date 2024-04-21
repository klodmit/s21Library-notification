package com.example.s21library_dbcontroller.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "visitor")
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nickname;
    private String chatId;
    private String role;


}
