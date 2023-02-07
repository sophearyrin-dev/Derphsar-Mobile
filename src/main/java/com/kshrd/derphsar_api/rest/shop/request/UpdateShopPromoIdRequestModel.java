package com.kshrd.derphsar_api.rest.shop.request;

public class UpdateShopPromoIdRequestModel {

    private int promo_id;


    public UpdateShopPromoIdRequestModel() {
    }

    public UpdateShopPromoIdRequestModel(int promo_id) {
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
        return "UpdateShopPromoIdRequestModel{" +
                "promo_id=" + promo_id +
                '}';
    }
}
