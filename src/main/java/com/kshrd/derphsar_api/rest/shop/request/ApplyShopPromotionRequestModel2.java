package com.kshrd.derphsar_api.rest.shop.request;

import java.util.Arrays;

public class ApplyShopPromotionRequestModel2 {
    int[] id;
    int promo_id;

    public ApplyShopPromotionRequestModel2() {
    }

    public ApplyShopPromotionRequestModel2(int[] id, int promo_id) {
        this.id = id;
        this.promo_id = promo_id;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    @Override
    public String toString() {
        return "ApplyShopPromotionRequestModel2{" +
                "id=" + Arrays.toString(id) +
                ", promo_id=" + promo_id +
                '}';
    }
}
