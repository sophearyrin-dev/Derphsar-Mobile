package com.kshrd.derphsar_api.rest.promotion.response;

public class PromotionResponseShopId {
    private int id;
    private int promo_id;
    private int shop_id;
    private boolean status;
    private PromotionResponseModel promotion;

    public PromotionResponseShopId() {
    }

    public PromotionResponseShopId(int id, int promo_id, int shop_id, boolean status, PromotionResponseModel promotion) {
        this.id = id;
        this.promo_id = promo_id;
        this.shop_id = shop_id;
        this.status = status;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
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

    public PromotionResponseModel getPromotion() {
        return promotion;
    }

    public void setPrmotion(PromotionResponseModel promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "PromotionResponseShopId{" +
                "id=" + id +
                ", promotion_id=" + promo_id +
                ", shop_id=" + shop_id +
                ", status=" + status +
                ", promotion=" + promotion +
                '}';
    }
}
