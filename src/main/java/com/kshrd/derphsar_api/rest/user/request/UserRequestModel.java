package com.kshrd.derphsar_api.rest.user.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kshrd.derphsar_api.repository.dto.RoleDto;

public class UserRequestModel {

    @JsonIgnore
    private String userId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String password;
    private String profile;
    private String firebaseIds;
    @JsonIgnore
    private boolean status;
    @JsonIgnore
    private RoleDto role;

    public UserRequestModel(){}

    public UserRequestModel(String userId, String name, String gender, String phone, String email, String password, String profile, boolean status, String firebaseIds, RoleDto role) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.status = status;
        this.firebaseIds = firebaseIds;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRequestModel{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                ", status=" + status +
                ", firebaseIds='" + firebaseIds + '\'' +
                ", role=" + role +
                '}';
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    //firebaseId
    public String getFirebaseIds(){
        return firebaseIds;
    }
    public void setFirebaseIds(String firebaseIds){
        this.firebaseIds = firebaseIds;
    }
}
