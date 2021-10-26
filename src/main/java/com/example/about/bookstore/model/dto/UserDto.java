//package com.example.about.bookstore.model.dto;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//
//public class UserDto {
//    private Long userId;
//    @NotEmpty(message = "Enter your name")
//    private String userName;
//    @NotEmpty(message = "Enter your email")
//    @Email(message = "Enter a valid email address")
//    private String email;
//    @NotEmpty(message = "Enter your password")
//    @Size(min = 6, message = "Passwords must be at least 6 characters")
//    private String password;
//    @NotEmpty(message = "Re-enter your password")
//    private String rpassword;
//
//    public UserDto() {
//    }
//
//    public UserDto(Long userId, String userName, String email, String password, String rpassword) {
//        this.userId = userId;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//        this.rpassword = rpassword;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRpassword() {
//        return rpassword;
//    }
//
//    public void setRpassword(String rpassword) {
//        this.rpassword = rpassword;
//    }
//
//}
