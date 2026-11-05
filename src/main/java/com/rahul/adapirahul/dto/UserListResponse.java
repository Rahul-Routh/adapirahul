package com.rahul.adapirahul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahul.adapirahul.User;
import java.util.List;

public class UserListResponse {

    @JsonProperty("status_code")
    private String statusCode;

    private String message;

    @JsonProperty("user_list")
    private List<User> userList;

    public UserListResponse() {}

    public UserListResponse(String statusCode, String message, List<User> userList) {
        this.statusCode = statusCode;
        this.message = message;
        this.userList = userList;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}