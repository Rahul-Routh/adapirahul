package com.rahul.adapirahul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthDtos.Response> register(@RequestBody AuthDtos.Request req) {
        if (req.getEmail() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body(new AuthDtos.Response(false, "Email and password are required"));
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body(new AuthDtos.Response(false, "Email already registered"));
        }

        userRepository.save(new User(req.getEmail(), req.getPassword()));
        return ResponseEntity.ok(new AuthDtos.Response(true, "Registration successful"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDtos.Response> login(@RequestBody AuthDtos.Request req) {
        Optional<User> user = userRepository.findByEmail(req.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(req.getPassword())) {
            return ResponseEntity.ok(new AuthDtos.Response(true, "Login successful"));
        }
        return ResponseEntity.status(401).body(new AuthDtos.Response(false, "Invalid email or password"));
    }
}