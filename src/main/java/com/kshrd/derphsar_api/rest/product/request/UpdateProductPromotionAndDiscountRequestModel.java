package com.kshrd.derphsar_api.rest.product.request;

public class UpdateProductPromotionAndDiscountRequestModel {

    private int promo_id;
    private double discount;

    public UpdateProductPromotionAndDiscountRequestModel() {
    }

    public UpdateProductPromotionAndDiscountRequestModel(int promo_id, double discount) {
        this.promo_id = promo_id;
        this.discount = discount;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "UpdateProductPromotionAndDiscountRequestModel{" +
                "promo_id=" + promo_id +
                ", discount=" + discount +
                '}';
    }
}
