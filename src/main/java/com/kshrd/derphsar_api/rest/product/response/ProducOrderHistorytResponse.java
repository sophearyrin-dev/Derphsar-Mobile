package com.kshrd.derphsar_api.rest.product.response;

import java.sql.Date;

public class ProducOrderHistorytResponse {
    private String name;
    private Double price;
    private Object images;

    private String description;
    private boolean status;
    private boolean soldStatus;
    private int viewCount;
    private Date postDate;
    private Double discount;
    private int shop_id;
    private int promo_id;
    private Object details;

    public ProducOrderHistorytResponse() {
    }

    public ProducOrderHistorytResponse(String name, Double price, Object images, String description, boolean status, boolean soldStatus, int viewCount, Date postDate, Double discount, int shop_id, int promo_id, Object details) {
        this.name = name;
        this.price = price;
        this.images = images;
        this.description = description;
        this.status = status;
        this.soldStatus = soldStatus;
        this.viewCount = viewCount;
        this.postDate = postDate;
        this.discount = discount;
        this.shop_id = shop_id;
        this.promo_id = promo_id;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(boolean soldStatus) {
        this.soldStatus = soldStatus;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ProducOrderHistorytResponse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", soldStatus=" + soldStatus +
                ", viewCount=" + viewCount +
                ", postDate=" + postDate +
                ", discount=" + discount +
                ", shop_id=" + shop_id +
                ", promo_id=" + promo_id +
                ", details=" + details +
                '}';
    }
}
