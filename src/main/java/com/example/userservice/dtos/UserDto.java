package com.example.userservice.dtos;
import java.util.List;

import com.example.userservice.models.Role;

import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;

}
