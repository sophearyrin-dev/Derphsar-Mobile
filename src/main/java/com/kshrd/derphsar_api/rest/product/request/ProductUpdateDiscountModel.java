package com.kshrd.derphsar_api.rest.product.request;

public class ProductUpdateDiscountModel {
    private Double discount;
    private int promoId;

    public ProductUpdateDiscountModel() {
    }

    public ProductUpdateDiscountModel(Double discount, int promoId) {
        this.discount = discount;
        this.promoId = promoId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Override
    public String toString() {
        return "ProductUpdateDiscountModel{" +
                "discount=" + discount +
                ", promoId=" + promoId +
                '}';
    }
}
