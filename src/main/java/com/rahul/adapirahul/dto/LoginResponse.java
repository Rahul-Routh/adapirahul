package com.rahul.adapirahul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahul.adapirahul.User;

public class LoginResponse {

    @JsonProperty("status_code")
    private String statusCode;

    private String message;

    private User user;

    public LoginResponse(String statusCode, String message, User user) {
        this.statusCode = statusCode;
        this.message = message;
        this.user = user;
    }

    public String getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public User getUser() { return user; }
}