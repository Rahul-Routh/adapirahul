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

    // POST /api/auth/register
    @PostMapping("/register")
    public ResponseEntity<AuthDtos.Response> register(@RequestBody AuthDtos.RegisterRequest req) {
        if (req.getEmail() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body(new AuthDtos.Response(false, "Email and password are required"));
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body(new AuthDtos.Response(false, "Email already registered"));
        }

        User user = new User(
                req.getEmail(),
                req.getPassword(),
                req.getName(),
                req.getAge(),
                req.getGender(),
                req.getDob(),
                req.getState()
        );
        userRepository.save(user);

        return ResponseEntity.ok(new AuthDtos.Response(true, "Registration successful"));
    }

    // POST /api/auth/login -> returns all user profile data upon success
    @PostMapping("/login")
    public ResponseEntity<AuthDtos.Response> login(@RequestBody AuthDtos.LoginRequest req) {
        Optional<User> userOptional = userRepository.findByEmail(req.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(req.getPassword())) {
                AuthDtos.UserProfile profile = new AuthDtos.UserProfile(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getAge(),
                        user.getGender(),
                        user.getDob(),
                        user.getState()
                );
                return ResponseEntity.ok(new AuthDtos.Response(true, "Login successful", profile));
            }
        }

        return ResponseEntity.status(401).body(new AuthDtos.Response(false, "Invalid email or password"));
    }

    // GET /api/auth/users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}