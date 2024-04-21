package com.example.s21library_dbcontroller.service;

import com.example.s21library_dbcontroller.entities.CheckUserDto;
import com.example.s21library_dbcontroller.entities.Visitor;
import com.example.s21library_dbcontroller.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(Visitor visitor) {
        userRepository.save(visitor);
    }
    public Visitor checkUser(CheckUserDto checkUserDto) {
        log.info("recieved {}", checkUserDto.toString());
        Visitor check = userRepository.findByChatId(checkUserDto.getChatId()).orElse(null);
        log.info("ret {}", check);
        return check;
    }

}
