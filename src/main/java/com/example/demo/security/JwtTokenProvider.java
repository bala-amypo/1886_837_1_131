package com.example.demo.security;

import com.example.demo.entity.AppUser;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    private static final String SEPARATOR = ":";

    // -------- CREATE TOKEN --------
    public String createToken(AppUser user) {

        String payload =
                user.getEmail() + SEPARATOR +
                user.getRole() + SEPARATOR +
                user.getId();

        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    // -------- VALIDATE TOKEN --------
    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // -------- GET CLAIMS --------
    public Claims getClaims(String token) {

        String decoded = new String(Base64.getDecoder().decode(token));
        String[] parts = decoded.split(SEPARATOR);

        Claims claims = new Claims();
        claims.setSubject(parts[0]);           // email
        claims.put("role", parts[1]);           // role
        claims.put("userId", Long.parseLong(parts[2]));

        return claims;
    }

    // -------- SIMPLE CLAIMS CLASS --------
    public static class Claims extends HashMap<String, Object> {

        private String subject;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }
}
