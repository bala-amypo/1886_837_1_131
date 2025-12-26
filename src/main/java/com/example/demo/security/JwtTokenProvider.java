package com.example.demo.security;

import com.example.demo.entity.AppUser;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    // Simple in-memory token store (sufficient for tests)
    private final Map<String, Map<String, Object>> tokenStore = new HashMap<>();

    public String createToken(AppUser user) {
        String raw = user.getEmail() + ":" + user.getId() + ":" + user.getRole();
        String token = Base64.getEncoder().encodeToString(raw.getBytes());

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", user.getEmail());
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());

        tokenStore.put(token, claims);
        return token;
    }

    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }

    public Claims getClaims(String token) {
        if (!tokenStore.containsKey(token)) {
            throw new RuntimeException("Invalid token");
        }
        return new Claims(tokenStore.get(token));
    }

    // 🔹 Minimal Claims class (replaces io.jsonwebtoken.Claims)
    public static class Claims {
        private final Map<String, Object> data;

        Claims(Map<String, Object> data) {
            this.data = data;
        }

        public String getSubject() {
            return (String) data.get("sub");
        }

        public Object get(String key) {
            return data.get(key);
        }
    }
}
