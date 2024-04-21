package com.example.s21library_dbcontroller.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CheckUserDto {

    private String nickname;
    private String chatId;
}
