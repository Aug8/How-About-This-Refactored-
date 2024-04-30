package com.HUFS19.backend.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private SecretKey secretKey;

    public JwtUtil(@Value("${spring.jwt.secret}") String secret){
        secretKey = new SecretKeySpec(
                secret.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
    }

    public String getUserId(String token){
        String userId = null;
        try{
            userId= Jwts.parser().verifyWith(secretKey).build()
                    .parseSignedClaims(token)
                    .getPayload().get("userId", String.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userId;
    }

    public boolean checkExpire(String token){
        boolean isExpired = true;
        try{
            isExpired= Jwts.parser().verifyWith(secretKey).build()
                    .parseSignedClaims(token)
                    .getPayload().getExpiration().before(new Date());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isExpired;
    }

    public String createJwt(String userId, Long expiredMs){
        return Jwts.builder()
                .claim("userId", userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+expiredMs))
                .signWith(secretKey)
                .compact();
    }

}
