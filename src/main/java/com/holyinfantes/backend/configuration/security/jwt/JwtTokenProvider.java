package com.holyinfantes.backend.configuration.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtTokenProvider {

    @Autowired
    private JwtConfig jwt;

    private final long EXPIRATION_TIME = 864_000_000;

    public String generateToken(String username, Long userId) {
        Date dateToday = new Date();
        Date expiryDate = new Date(dateToday.getTime() + EXPIRATION_TIME);

        byte[] keyBytes = Decoders.BASE64.decode(jwt.getSecret());

        Key secretKey = Keys.hmacShaKeyFor(keyBytes);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(dateToday)
                .expiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

}
