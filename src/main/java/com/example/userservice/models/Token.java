package com.example.userservice.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tokens")
public class Token extends BaseModel {
    private String value;
    private Date expiryDate;

    @ManyToOne
    private User user;

}

// cardinality between token and user
// Token ==== User => M:1