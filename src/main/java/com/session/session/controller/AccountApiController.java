package com.session.session.controller;

import com.session.session.model.LoginRequest;
import com.session.session.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {
    private final UserService userService;



    @PostMapping("/login")
    public void login(
        @RequestBody
        LoginRequest loginRequest,

        HttpSession httpSession
    ){
        userService.login(loginRequest,httpSession);
    }
}
