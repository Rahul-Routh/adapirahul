package com.rahul.adapirahul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore // Keeps password hidden in login/users JSON responses
    @Column(nullable = false)
    private String password;

    private String name;
    private Integer age;
    private String gender;
    private String dob;
    private String state;

    @JsonProperty("profile_image")
    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String profileImage;

    public User() {}

    // Used during registration (profileImage defaults to null)
    public User(String email, String password, String name, Integer age,
                String gender, String dob, String state) {
        this(email, password, name, age, gender, dob, state, null);
    }

    public User(String email, String password, String name, Integer age,
                String gender, String dob, String state, String profileImage) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.state = state;
        this.profileImage = profileImage;
    }

    // Getters and Setters
    public Long getId() { return id; }
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
    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
}