package com.scalar.bookmyshow.controllers;

import com.scalar.bookmyshow.dtos.SignUpUserRequestDto;
import com.scalar.bookmyshow.dtos.SignUpUserResponseDto;
import com.scalar.bookmyshow.models.User;
import com.scalar.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpUserResponseDto signUpUser(SignUpUserRequestDto request){
        User user = userService.signUpuUser(
                request.getEmail(),
                request.getPassword()
        );

        SignUpUserResponseDto response = new SignUpUserResponseDto();
        response.setUserId(user.getId());

        return response;
    }
}
