package com.holyinfantes.backend.infrastructure.security.jwt;

import com.holyinfantes.backend.configuration.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {

    @Autowired
    private JwtConfig jwt;

    public String generateToken(String username, Long userId) {
        Date dateToday = new Date();
        long EXPIRATION_TIME = 864_000_000;
        Date expiryDate = new Date(dateToday.getTime() + EXPIRATION_TIME);

        byte[] keyBytes = Decoders.BASE64.decode(jwt.getSecret());
        Key secretKey = Keys.hmacShaKeyFor(keyBytes);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("logoutAt", null);

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(dateToday)
                .expiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            SecretKey secretKey =  Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwt.getSecret()));

            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromJwt(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwt.getSecret()));

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public Long getTokenIssuedAt(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwt.getSecret())))
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getIssuedAt().getTime();
    }
}
