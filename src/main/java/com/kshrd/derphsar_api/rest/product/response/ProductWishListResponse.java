package com.kshrd.derphsar_api.rest.product.response;

public class ProductWishListResponse {
    private String proId;
    private String name;
    private Object images;
    private Double price;

    public ProductWishListResponse() {
    }

    public ProductWishListResponse(String proId, String name, Object images, Double price) {
        this.proId = proId;
        this.name = name;
        this.images = images;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductWishListResponse{" +
                "proId='" + proId + '\'' +
                ", name='" + name + '\'' +
                ", images=" + images +
                ", price=" + price +
                '}';
    }
}
