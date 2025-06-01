package com.example.userservice.controllers;

import com.example.userservice.models.Token;
import com.example.userservice.dtos.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dtos.LoginRequestDto;
import com.example.userservice.dtos.LogoutRequestDto;
import com.example.userservice.dtos.SignUpRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/users")
public class UserController {
    

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto)
    {

            return null;
    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto ) {

        return null;
    }
    

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto)
    {
        return null;
    }

    @GetMapping("/validate")
    public UserDto validateToken(@PathVariable String tokenValue)
    {
        return null;
    }

    

}
