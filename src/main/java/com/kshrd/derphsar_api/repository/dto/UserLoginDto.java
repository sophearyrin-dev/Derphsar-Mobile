package com.kshrd.derphsar_api.repository.dto;

public class UserLoginDto {

    private String email;
    private String password;

    public UserLoginDto(){}

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserLoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
