package com.rahul.adapirahul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileImageRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("profile_image")
    private String profileImage;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
}