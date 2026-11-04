package com.rahul.adapirahul;

public class AuthDtos {

    // Request for Registration
    public static class RegisterRequest {
        private String email;
        private String password;
        private String name;
        private Integer age;
        private String gender;
        private String dob;
        private String state;

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

    // Request for Login
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    // Safe user profile model returned after login (no password exposed)
    public static class UserProfile {
        private Long id;
        private String email;
        private String name;
        private Integer age;
        private String gender;
        private String dob;
        private String state;

        public UserProfile(Long id, String email, String name, Integer age, String gender, String dob, String state) {
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

    // Universal Response: handles messages + returns user data
    public static class Response {
        private boolean success;
        private String message;
        private UserProfile user;

        public Response(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public Response(boolean success, String message, UserProfile user) {
            this.success = success;
            this.message = message;
            this.user = user;
        }

        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
        public UserProfile getUser() { return user; }
    }
}