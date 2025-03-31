package com.security.spring_security_1.service;

import com.security.spring_security_1.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secretKey = null;


    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
       return Jwts .builder().claims().add(claims)
               .subject(user.getName())
               .issuer("DCB")
               .issuedAt(new Date(System.currentTimeMillis()))
               .expiration(new Date(System.currentTimeMillis()+ 60*10*1000))
               .and()
               .signWith(generateKey())
               .compact();

    }
    private SecretKey generateKey(){
        byte[] decode = Decoders.BASE64.decode(getSecretKey());
       return Keys.hmacShaKeyFor(decode);
    }
    public String getSecretKey(){
        return secretKey = "RqxPOuVfHoBA8Uq40MhJvfY6qEHOOWWvg6N9W9vt23s=";
    }
}
