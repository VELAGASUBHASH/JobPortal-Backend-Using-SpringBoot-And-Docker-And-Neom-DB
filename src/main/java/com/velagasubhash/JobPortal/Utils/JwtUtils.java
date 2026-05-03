package com.velagasubhash.JobPortal.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.awt.desktop.SystemEventListener;
import java.util.Date;

@Component
public class JwtUtils {
        private final String SECRET="thislongestsecertintheworld";

    public String generateJWT(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
