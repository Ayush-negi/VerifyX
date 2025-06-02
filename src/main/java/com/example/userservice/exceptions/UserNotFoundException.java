package com.example.userservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message)
    {
        super(message);
        
    }

}
