package com.rahul.adapirahul.controller;

import com.rahul.adapirahul.User;
import com.rahul.adapirahul.UserRepository;
import com.rahul.adapirahul.dto.ApiResponse;
import com.rahul.adapirahul.dto.ProfileImageRequest;
import com.rahul.adapirahul.dto.UserListResponse;
import com.rahul.adapirahul.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageStorageService imageStorageService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/users")
    public ResponseEntity<UserListResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return ResponseEntity.ok(new UserListResponse("200", "No users found", users));
        }

        return ResponseEntity.ok(new UserListResponse("200", "Success", users));
    }

    @PostMapping("/update-profile-image")
    public ResponseEntity<ApiResponse> updateProfileImage(@RequestBody ProfileImageRequest request) {
        if (request.getUserId() == null ||
                request.getProfileImage() == null || request.getProfileImage().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("400", "user_id and profile_image are required"));
        }

        Optional<User> optionalUser = userRepository.findById(request.getUserId());
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("404", "User not found"));
        }

        try {
            // Save image on Render server and get https://adapirahul.onrender.com/uploads/... URL
            String imageUrl = imageStorageService.saveBase64Image(request.getUserId(), request.getProfileImage());

            // Save URL in database
            User user = optionalUser.get();
            user.setProfileImage(imageUrl);
            userRepository.save(user);

            return ResponseEntity.ok(new ApiResponse("200", "Profile image updated successfully"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("400", "Invalid Base64 image format"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("500", "Failed to save image: " + e.getMessage()));
        }
    }
}