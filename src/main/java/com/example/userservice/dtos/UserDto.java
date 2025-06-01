package com.example.userservice.dtos;
import java.util.List;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import com.example.userservice.models.User;
import com.example.userservice.models.Role;


import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;

    public static UserDto from(User user)
    {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

}
