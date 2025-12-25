package com.example.demo.security;

import com.example.demo.entity.AppUser;
import io.jsonwebtoken.Claims;

import java.util.Base64;

public class JwtTokenProvider {

    public String createToken(AppUser user) {

        String payload =
                user.getEmail() + "|" +
                user.getRoles().iterator().next() + "|" +
                user.getId();

        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {

        String decoded = new String(Base64.getDecoder().decode(token));
        String[] parts = decoded.split("\\|");

        Claims claims = new Claims();
        claims.setSubject(parts[0]);
        claims.put("role", parts[1]);
        claims.put("userId", Long.parseLong(parts[2]));

        return claims;
    }
}
