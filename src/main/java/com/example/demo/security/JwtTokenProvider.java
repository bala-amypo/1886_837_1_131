package com.example.demo.security;

import com.example.demo.entity.AppUser;
import io.jsonwebtoken.*;
import java.util.Date;

public class JwtTokenProvider {

    private final String SECRET = "secret";
    private final long EXP = 3600000;

    public String createToken(AppUser u) {
        return Jwts.builder()
                .setSubject(u.getEmail())
                .claim("role", u.getRole())
                .claim("userId", u.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXP))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        getClaims(token);
        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
