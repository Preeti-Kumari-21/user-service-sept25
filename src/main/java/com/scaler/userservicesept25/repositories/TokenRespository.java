package com.scaler.userservicesept25.repositories;

import com.scaler.userservicesept25.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRespository extends JpaRepository<Token, Long> {
    @Override
    Token save(Token token);


    Optional<Token> findByValueAndExpiryDateAfter(String tokenValue, Date currentDate);
}
