package com.rahul.adapirahul.dto;

public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private Integer age;
    private String gender;
    private String dob;
    private String state;

    public RegisterRequest() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}