package com.kshrd.derphsar_api.rest.shop.request;

public class ShopPromotionRequestModel {
    private int shopId;

    public ShopPromotionRequestModel() {
    }

    public ShopPromotionRequestModel(int shopId) {
        this.shopId = shopId;
    }

    public int getShop_id() {
        return shopId;
    }

    public void setShop_id(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopPromotionRequestModel{" +
                "shop_id=" + shopId +
                '}';
    }
}
