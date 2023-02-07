package com.kshrd.derphsar_api.rest.shop.response;

public class UpdateShopPromoIdResponse {
    private int promo_id;


    public UpdateShopPromoIdResponse() {
    }

    public UpdateShopPromoIdResponse(int promo_id) {
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
        return "UpdateShopPromoIdResponse{" +
                "promo_id=" + promo_id +
                '}';
    }
}
