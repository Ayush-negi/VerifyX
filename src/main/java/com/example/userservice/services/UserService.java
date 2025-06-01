package com.example.userservice.services;
import com.example.userservice.models.User;
import com.example.userservice.models.Token;


public interface UserService {
    User signUp(String name, String email, String password);

    Token login(String email, String password);

    User validateToken(String tokenValue);

    void logout(String tokenValue);

}
