package com.kshrd.derphsar_api.rest.shop.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kshrd.derphsar_api.repository.dto.CategoryDto;
import com.kshrd.derphsar_api.repository.dto.PromotionDto;
import com.kshrd.derphsar_api.repository.dto.UserDto;

import java.util.Date;

public class ShopOrderHistoryResponse {
    private String name;
    private boolean status;
    private String shopId;
    private String address;
    private String description;
    private String profile;
    private String cover;
    private String contact;
    private boolean openStatus;
    private int u_id;
    private int cat_id;
    private int promo_id;
    private Date openTime;
    private Date closeTime;

    private UserDto user;
    private CategoryDto category;
    private PromotionDto promotion;


    public ShopOrderHistoryResponse() {
    }

    public ShopOrderHistoryResponse(String name, boolean status, String shopId, String address, String description, String profile, String cover, String contact, boolean openStatus, int u_id, int cat_id, int promo_id, Date openTime, Date closeTime, UserDto user, CategoryDto category, PromotionDto promotion) {
        this.name = name;
        this.status = status;
        this.shopId = shopId;
        this.address = address;
        this.description = description;
        this.profile = profile;
        this.cover = cover;
        this.contact = contact;
        this.openStatus = openStatus;
        this.u_id = u_id;
        this.cat_id = cat_id;
        this.promo_id = promo_id;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.user = user;
        this.category = category;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public PromotionDto getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionDto promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "ShopOrderHistoryResponse{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", shopId='" + shopId + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", profile='" + profile + '\'' +
                ", cover='" + cover + '\'' +
                ", contact='" + contact + '\'' +
                ", openStatus=" + openStatus +
                ", u_id=" + u_id +
                ", cat_id=" + cat_id +
                ", promo_id=" + promo_id +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", user=" + user +
                ", category=" + category +
                ", promotion=" + promotion +
                '}';
    }
}
