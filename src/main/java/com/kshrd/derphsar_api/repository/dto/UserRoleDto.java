package com.kshrd.derphsar_api.repository.dto;

public class UserRoleDto {
    private int id;
    private int userId;
    private int roleId;

    public UserRoleDto(){}

    public UserRoleDto(int id, int userId, int roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "UserRoleDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
