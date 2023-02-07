package com.kshrd.derphsar_api.rest.shop.response;

import com.kshrd.derphsar_api.rest.category.response.CategoryResponseModel;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;

import java.util.Date;

public class ShopResponseModel {

    private int id;
    private String shopId;
    private String name;
    private String address;
    private String description;
    private String profile;
    private String cover;
    private String contact;
    private boolean openStatus;
    private boolean status;
    private Date openTime;
    private Date closeTime;

    private UserResponseModel user;
    private CategoryResponseModel category;
    private PromotionDataResponse promotion1;

    //private List<PromotionResponseModel> promotion;

    public ShopResponseModel() {
    }

    public ShopResponseModel(int id, String shopId, String name, String address, String description, String profile, String cover, String contact, boolean openStatus, boolean status, Date openTime, Date closeTime, UserResponseModel user, CategoryResponseModel category, PromotionDataResponse promotion1) {
        this.id = id;
        this.shopId = shopId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.profile = profile;
        this.cover = cover;
        this.contact = contact;
        this.openStatus = openStatus;
        this.status = status;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.user = user;
        this.category = category;
        this.promotion1 = promotion1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public UserResponseModel getUser() {
        return user;
    }

    public void setUser(UserResponseModel user) {
        this.user = user;
    }

    public CategoryResponseModel getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseModel category) {
        this.category = category;
    }

    public PromotionDataResponse getPromotion1() {
        return promotion1;
    }

    public void setPromotion1(PromotionDataResponse promotion1) {
        this.promotion1 = promotion1;
    }

    @Override
    public String toString() {
        return "ShopResponseModel{" +
                "id=" + id +
                ", shopId='" + shopId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", profile='" + profile + '\'' +
                ", cover='" + cover + '\'' +
                ", contact='" + contact + '\'' +
                ", openStatus=" + openStatus +
                ", status=" + status +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", user=" + user +
                ", category=" + category +
                ", promotion=" + promotion1 +
                '}';
    }
}
