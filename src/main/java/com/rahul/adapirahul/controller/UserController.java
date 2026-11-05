package com.rahul.adapirahul.controller;

import com.rahul.adapirahul.User;
import com.rahul.adapirahul.UserRepository;
import com.rahul.adapirahul.dto.UserListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<UserListResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return ResponseEntity.ok(new UserListResponse("200", "No users found", users));
        }

        return ResponseEntity.ok(new UserListResponse("200", "Success", users));
    }
}