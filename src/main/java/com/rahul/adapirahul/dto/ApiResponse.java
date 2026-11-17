package com.rahul.adapirahul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    @JsonProperty("status_code")
    private String statusCode;
    private String message;

    public ApiResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
}