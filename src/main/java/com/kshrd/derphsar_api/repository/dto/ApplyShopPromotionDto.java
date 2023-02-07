package com.kshrd.derphsar_api.repository.dto;

public class ApplyShopPromotionDto {
    private int id;
    private int promo_id;
    private int shop_id;

    public ApplyShopPromotionDto() {
    }

    public ApplyShopPromotionDto(int id, int promo_id, int shop_id) {
        this.id = id;
        this.promo_id = promo_id;
        this.shop_id = shop_id;
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

    @Override
    public String toString() {
        return "ApplyShopPromotionDto{" +
                "id=" + id +
                ", promo_id=" + promo_id +
                ", shop_id=" + shop_id +
                '}';
    }
}