package com.example.userservice.services;

import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import com.example.userservice.exceptions.UnAuthorizedException;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.TokenRepository;
import com.example.userservice.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService 
{

    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, TokenRepository tokenRepository,  BCryptPasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;

    }



    @Override
    public Token login(String email, String password) throws UserNotFoundException, UnAuthorizedException 
    {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            // redirect to signUp
            throw new UserNotFoundException("user with email: "+ email+" not found.");
            
        }
        // create a token.
        User user = optionalUser.get();
        if (passwordEncoder.matches(password, user.getPassword()))
        {
            Token token = new Token();
            token.setUser(user);
            token.setValue(RandomStringUtils.randomAlphanumeric(128));

            Date currentDate = new Date(); // current date and time.
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);

            // Add 30 days to the calendar
            calendar.add(Calendar.DAY_OF_MONTH, 30);

            // Get the updated time as a Date object
            Date dateAfter30Days = calendar.getTime();
            
            token.setExpiryDate(dateAfter30Days);
            
            //return tokenRepository.save(token);
            return tokenRepository.save(token);
        }

        //login failed
        throw new UnAuthorizedException("The user is unauthorized to login");
    }

    @Override
    public void logout(String tokenValue) 
    {

        Optional<Token> optionalToken = tokenRepository.findByValue(tokenValue);

        if (optionalToken.isEmpty()) {
            throw new RuntimeException("Token Invalid.");
        }

        Token token = optionalToken.get();
        token.setDeleted(true);
        tokenRepository.save(token);

        
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
        user.setPassword(passwordEncoder.encode(password));
        // later password needs to be stored in the encoded form using BCrypt Password Encoder.


        return userRepository.save(user);
    }

    @Override
    public User validateToken(String tokenValue) {
                //Check if the token is present in the DB, token is NOT deleted and
        //token's expiry time is greater than the current time.
        Optional<Token> optionalToken = tokenRepository.findByValueAndDeletedAndExpiryDateGreaterThan(
                        tokenValue,
                        false,
                        new Date()
                );

        //Token invalid
        return optionalToken.map(Token::getUser).orElse(null);
        // :: this is called the refrence operator and in the above we are using streams.
    }



}
