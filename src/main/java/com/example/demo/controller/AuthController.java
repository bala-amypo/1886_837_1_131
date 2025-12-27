package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;          // ✅ REQUIRED IMPORT
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AppUserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest req) {

        // ✅ encode password correctly
        String encodedPassword = passwordEncoder.encode(req.getPassword());

        AppUser user = new AppUser();
        user.setEmail(req.getEmail());
        user.setPassword(encodedPassword);
        user.setRole("USER");

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
