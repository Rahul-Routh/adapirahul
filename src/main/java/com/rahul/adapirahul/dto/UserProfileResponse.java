package com.rahul.adapirahul.dto;

public class UserProfileResponse {
    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String gender;
    private String dob;
    private String state;

    public UserProfileResponse() {}

    public UserProfileResponse(Long id, String email, String name, Integer age, String gender, String dob, String state) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.state = state;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    public String getState() { return state; }
}