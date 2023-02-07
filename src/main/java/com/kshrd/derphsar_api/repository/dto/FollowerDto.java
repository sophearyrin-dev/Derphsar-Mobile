package com.kshrd.derphsar_api.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FollowerDto {
    private int id;
    private String follow_id;
    private int u_id;
    private int shop_id;

    private boolean status;

    private ShopDto shop;
    private UserDto user;
    private PromotionDto promotion;

    public FollowerDto() {
    }

    public FollowerDto(String follow_id, int u_id, int shop_id, boolean status, ShopDto shop, UserDto user, PromotionDto promotion) {
        this.follow_id = follow_id;
        this.u_id = u_id;
        this.shop_id = shop_id;
        this.status = status;
        this.shop = shop;
        this.user = user;
        this.promotion = promotion;
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

    public ShopDto getShop() {
        return shop;
    }

    public void setShop(ShopDto shop) {
        this.shop = shop;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PromotionDto getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionDto promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "FollowerDto{" +
                "id=" + id +
                ", follow_id='" + follow_id + '\'' +
                ", u_id=" + u_id +
                ", shop_id=" + shop_id +
                ", status=" + status +
                ", shop=" + shop +
                ", user=" + user +
                ", promotion=" + promotion +
                '}';
    }
}
