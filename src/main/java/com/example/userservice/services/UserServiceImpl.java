package com.example.userservice.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService 
{

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;

    }



    @Override
    public Token login(String email, String password) {

        return null;
    }

    @Override
    public void logout(String tokenValue) {

        
    }

    @Override
    public User signUp(String name, String email, String password) 
    {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            // redirect to login
            return optionalUser.get();
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        // later password needs to be stored in the encoded form using BCrypt Password Encoder.


        return userRepository.save(user);
    }

    @Override
    public User validateToken(String tokenValue) {

        return null;
    }



}
