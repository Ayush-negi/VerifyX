package com.example.userservice.services;
import com.example.userservice.models.User;
import com.example.userservice.exceptions.UnAuthorizedException;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.models.Token;


public interface UserService {
    User signUp(String name, String email, String password);

    Token login(String email, String password) throws UserNotFoundException, UnAuthorizedException ;

    User validateToken(String tokenValue);

    void logout(String tokenValue);

}
