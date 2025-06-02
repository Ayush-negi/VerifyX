package com.example.userservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnAuthorizedException extends Exception{

    public UnAuthorizedException(String message) {
        super(message);
    }

}
