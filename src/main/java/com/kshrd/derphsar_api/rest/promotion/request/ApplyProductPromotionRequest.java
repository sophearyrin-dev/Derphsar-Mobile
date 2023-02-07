package com.kshrd.derphsar_api.rest.promotion.request;

import java.util.Arrays;

public class ApplyProductPromotionRequest {
    private int[] id;
    private int promo_id;
    private Double discount;

    public ApplyProductPromotionRequest() {
    }

    public ApplyProductPromotionRequest(int[] id, int promo_id, Double discount) {
        this.id = id;
        this.promo_id = promo_id;
        this.discount = discount;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ApplyProductPromotionRequest{" +
                "id=" + Arrays.toString(id) +
                ", promo_id=" + promo_id +
                ", discount=" + discount +
                '}';
    }
}
