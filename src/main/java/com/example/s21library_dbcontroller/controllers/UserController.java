package com.example.s21library_dbcontroller.controllers;

import com.example.s21library_dbcontroller.entities.CheckUserDto;
import com.example.s21library_dbcontroller.entities.Visitor;
import com.example.s21library_dbcontroller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/reg-User")
    public String regNewUser(@RequestBody Visitor visitor) {
        userService.saveUser(visitor);
        return "success";
    }

    @PostMapping("/check-access")
    public Visitor checkAccess(@RequestBody CheckUserDto checkUserDto) {
        return  userService.checkUser(checkUserDto);
    }
}
