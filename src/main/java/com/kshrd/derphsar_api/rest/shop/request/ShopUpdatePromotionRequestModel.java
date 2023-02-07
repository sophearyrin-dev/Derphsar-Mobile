package com.kshrd.derphsar_api.rest.shop.request;

public class ShopUpdatePromotionRequestModel {
    private int promo_id;

    public ShopUpdatePromotionRequestModel() {
    }

    public ShopUpdatePromotionRequestModel(int promo_id) {
        this.promo_id = promo_id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    @Override
    public String toString() {
        return "ShopUpdatePromotionRequestModel{" +
                "promo_id=" + promo_id +
                '}';
    }
}
