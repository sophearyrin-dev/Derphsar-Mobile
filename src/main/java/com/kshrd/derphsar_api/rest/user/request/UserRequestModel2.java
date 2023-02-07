package com.kshrd.derphsar_api.rest.user.request;

public class UserRequestModel2 {
    private String address;

    public UserRequestModel2(String address) {
        this.address = address;
    }

    public UserRequestModel2() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserRequestModel2{" +
                "address='" + address + '\'' +
                '}';
    }
}
