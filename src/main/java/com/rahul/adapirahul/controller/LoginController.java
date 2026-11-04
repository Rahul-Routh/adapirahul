package com.rahul.adapirahul.controller;

import com.rahul.adapirahul.User;
import com.rahul.adapirahul.UserRepository;
import com.rahul.adapirahul.dto.ApiResponse;
import com.rahul.adapirahul.dto.LoginRequest;
import com.rahul.adapirahul.dto.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest req) {
        Optional<User> userOptional = userRepository.findByEmail(req.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(req.getPassword())) {
                UserProfileResponse profile = new UserProfileResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getAge(),
                        user.getGender(),
                        user.getDob(),
                        user.getState()
                );
                return ResponseEntity.ok(new ApiResponse(true, "Login successful", profile));
            }
        }

        return ResponseEntity.status(401).body(new ApiResponse(false, "Invalid email or password"));
    }
}