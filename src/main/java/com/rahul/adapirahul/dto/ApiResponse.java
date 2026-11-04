package com.rahul.adapirahul.dto;

public class ApiResponse {
    private boolean success;
    private String message;
    private UserProfileResponse user;

    public ApiResponse() {}

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, UserProfileResponse user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public UserProfileResponse getUser() { return user; }
}