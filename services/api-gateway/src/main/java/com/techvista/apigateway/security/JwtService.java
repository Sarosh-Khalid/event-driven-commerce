package com.techvista.apigateway.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;


@Service
public class JwtService {


    @Value("${jwt.secret}")
    private String secret;

    private SecretKey key(){

        return Keys.hmacShaKeyFor(
                secret.getBytes()
        );
    }


    public boolean validate(String token){

        try {

            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parseSignedClaims(token);

            return true;

        }catch(Exception e){

            return false;
        }

    }

}