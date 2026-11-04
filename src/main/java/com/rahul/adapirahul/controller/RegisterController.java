package com.rahul.adapirahul.controller;

import com.rahul.adapirahul.User;
import com.rahul.adapirahul.UserRepository;
import com.rahul.adapirahul.dto.ApiResponse;
import com.rahul.adapirahul.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest req) {
        if (req.getEmail() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email and password are required"));
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email already registered"));
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

        return ResponseEntity.ok(new ApiResponse(true, "Registration successful"));
    }
}