package com.kshrd.derphsar_api.rest.ApplyProductPromotion.response;

public class ApplyProductPromotionResponseModel {

    private int id;
    private int promotion_id;
    private int product_id;

    public ApplyProductPromotionResponseModel() {
    }

    public ApplyProductPromotionResponseModel(int id, int promotion_id, int product_id) {
        this.id = id;
        this.promotion_id = promotion_id;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "ApplyProductPromotionResponseModel{" +
                "id=" + id +
                ", promotion_id=" + promotion_id +
                ", product_id=" + product_id +
                '}';
    }
}
