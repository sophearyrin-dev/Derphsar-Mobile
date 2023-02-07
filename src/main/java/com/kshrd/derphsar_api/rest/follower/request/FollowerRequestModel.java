package com.kshrd.derphsar_api.rest.follower.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FollowerRequestModel {

    @JsonIgnore
    private int id;
    @JsonIgnore
    private String follower_id;
    private int u_id;
    private int shop_id;
    @JsonIgnore
    private boolean status;

    public FollowerRequestModel(int id, String follower_id, int u_id, int shop_id, boolean status) {
        this.id = id;
        this.follower_id = follower_id;
        this.u_id = u_id;
        this.shop_id = shop_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FollowerRequestModel{" +
                "id=" + id +
                ", follower_id=" + follower_id +
                ", u_id=" + u_id +
                ", shop_id=" + shop_id +
                ", status=" + status +
                '}';
    }
}
