package com.example.userservice.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private Long id;


    private Date createdAt;

    
    private Date lastModifiedAt;

    private boolean deleted;

}
