package com.kshrd.derphsar_api.repository.dto;

import java.sql.Date;

public class PromotionDto {

    private int id;
    private String promoId;
    private String title;
    private boolean isApply;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private String cover;
    private double startRank;
    private double endRank;

    private ShopDto shop;
    private UserDto user;


    private int shop_id;
    private int u_id;

    public PromotionDto() {
    }

    public PromotionDto(int id, String promoId, String title, boolean isApply, Date startDate, Date endDate, boolean status, String cover, double startRank, double endRank, ShopDto shop, UserDto user, int shop_id, int u_id) {
        this.id = id;
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
        this.user = user;
        this.shop_id = shop_id;
        this.u_id = u_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ShopDto getShop() {
        return shop;
    }

    public void setShop(ShopDto shop) {
        this.shop = shop;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "PromotionDto{" +
                "id=" + id +
                ", promoId='" + promoId + '\'' +
                ", title='" + title + '\'' +
                ", isApply=" + isApply +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", cover='" + cover + '\'' +
                ", startRank=" + startRank +
                ", endRank=" + endRank +
                ", shop=" + shop +
                ", user=" + user +
                ", shop_id=" + shop_id +
                ", u_id=" + u_id +
                '}';
    }
}
