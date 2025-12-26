package com.example.demo.security;

import com.example.demo.entity.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "smartgrid-secret-key";
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    /* =========================
       TOKEN CREATION
       ========================= */

    // ✔ Used by AuthController
    public String createToken(AppUser user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole())
                .claim("userId", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /* =========================
       TOKEN VALIDATION
       ========================= */

    // ✔ Used by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* =========================
       CLAIM EXTRACTION
       ========================= */

    // ✔ Used by JwtAuthenticationFilter
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    /* =========================
       OPTIONAL HELPER
       ========================= */

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }
}
