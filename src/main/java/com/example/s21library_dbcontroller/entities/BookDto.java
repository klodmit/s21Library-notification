package com.example.s21library_dbcontroller.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDto {
    private Long id;
    private String chatId;
    private String author;
    private String title;
    private String changeAuthor;
    private String changeTitle;
    private String genre;
    private Integer copies;
    private Integer rating;
}
