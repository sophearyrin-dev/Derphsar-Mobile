package com.kshrd.derphsar_api.rest.follower.response;

public class FollowerResponseModel {
    private int id;
    private String follow_id;
    private int u_id;
    private int shop_id;
    private boolean status;

    public FollowerResponseModel(int id, String follow_id, int u_id, int shop_id, boolean status) {
        this.id = id;
        this.follow_id = follow_id;
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

    public String getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(String follow_id) {
        this.follow_id = follow_id;
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
        return "FollowerResponseModel{" +
                "id=" + id +
                ", follow_id=" + follow_id +
                ", u_id=" + u_id +
                ", shop_id=" + shop_id +
                ", status=" + status +
                '}';
    }
}
