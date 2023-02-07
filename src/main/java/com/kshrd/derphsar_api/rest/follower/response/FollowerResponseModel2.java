package com.kshrd.derphsar_api.rest.follower.response;

import com.kshrd.derphsar_api.rest.promotion.response.PromotionProductResponse;
import com.kshrd.derphsar_api.rest.shop.response.ShopResponseModel;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;

public class FollowerResponseModel2 {

    private int id;
    private String follow_id;
    private int u_id;
    private int shop_id;
    private boolean status;


    private ShopResponseModel shop;
    private UserResponseModel user;
    private PromotionProductResponse promotion;

    public FollowerResponseModel2() {
    }

    public FollowerResponseModel2(int id, String follow_id, int u_id, int shop_id, boolean status, ShopResponseModel shop, UserResponseModel user, PromotionProductResponse promotion) {
        this.id = id;
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

    public ShopResponseModel getShop() {
        return shop;
    }

    public void setShop(ShopResponseModel shop) {
        this.shop = shop;
    }

    public UserResponseModel getUser() {
        return user;
    }

    public void setUser(UserResponseModel user) {
        this.user = user;
    }

    public PromotionProductResponse getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionProductResponse promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "FollowerResponseModel2{" +
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
