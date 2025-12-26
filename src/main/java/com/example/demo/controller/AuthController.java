package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.AppUser;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider provider;

    public AuthController(
            AppUserRepository repo,
            PasswordEncoder encoder,
            JwtTokenProvider provider) {
        this.repo = repo;
        this.encoder = encoder;
        this.provider = provider;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AuthRequest req) {

        if (repo.findByEmail(req.getEmail()).isPresent())
            throw new BadRequestException("unique");

            AppUser user = new AppUser();
        user.setEmail(req.getEmail());
        user.setPassword(encodedPassword);
        user.setRole("USER");


        return repo.save(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {

        AppUser user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new BadRequestException("Invalid credentials");

        String token = provider.createToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
