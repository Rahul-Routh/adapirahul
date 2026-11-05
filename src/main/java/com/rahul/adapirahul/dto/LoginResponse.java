package com.rahul.adapirahul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    @JsonProperty("status_code")
    private String statusCode;

    private String message;

    private UserProfileResponse user;

    public LoginResponse() {}

    public LoginResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public LoginResponse(String statusCode, String message, UserProfileResponse user) {
        this.statusCode = statusCode;
        this.message = message;
        this.user = user;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserProfileResponse getUser() {
        return user;
    }

    public void setUser(UserProfileResponse user) {
        this.user = user;
    }
}