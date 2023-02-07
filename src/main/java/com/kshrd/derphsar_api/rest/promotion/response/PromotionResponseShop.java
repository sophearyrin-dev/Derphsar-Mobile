package com.kshrd.derphsar_api.rest.promotion.response;
import com.kshrd.derphsar_api.rest.shop.response.ShopPromotionResponse;

import java.sql.Date;

public class PromotionResponseShop {

    private String promoId;
    private String title;
    private boolean isApply;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private String cover;
    private double startRank;
    private double endRank;
    private ShopPromotionResponse shop;

    private PromotionResponseModel promotion;

    public PromotionResponseShop(){}

    public PromotionResponseShop(String promoId, String title, boolean isApply, Date startDate, Date endDate, boolean status, String cover, double startRank, double endRank, ShopPromotionResponse shop, PromotionResponseModel promotion) {
        this.promoId = promoId;
        this.title = title;
        this.isApply = isApply;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.cover = cover;
        this.startRank = startRank;
        this.endRank = endRank;
        this.shop = shop;
        this.promotion = promotion;
    }

    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public double getStartRank() {
        return startRank;
    }

    public void setStartRank(double startRank) {
        this.startRank = startRank;
    }

    public double getEndRank() {
        return endRank;
    }

    public void setEndRank(double endRank) {
        this.endRank = endRank;
    }

    public ShopPromotionResponse getShop() {
        return shop;
    }

    public void setShop(ShopPromotionResponse shop) {
        this.shop = shop;
    }

    public PromotionResponseModel getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionResponseModel promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "PromotionResponseModel{" +
                "promoId='" + promoId + '\'' +
                ", title='" + title + '\'' +
                ", isApply=" + isApply +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", cover='" + cover + '\'' +
                ", startRank=" + startRank +
                ", endRank=" + endRank +
                ", shop=" + shop +
                ", promotion=" + promotion +
                '}';
    }
}

