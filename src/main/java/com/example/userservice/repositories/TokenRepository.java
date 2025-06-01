package com.example.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.models.Token;


@Repository
public interface TokenRepository extends JpaRepository<Token,Long>{

    Token save(Token token);

}
