package com.kshrd.derphsar_api.rest.orderdetail.response;

import com.kshrd.derphsar_api.rest.order.response.OrderResponse;
import com.kshrd.derphsar_api.rest.product.response.ProductOrderDetailResponse;

import java.sql.Date;

public class OrderDetailResponse {

    private int id;
    private String itemId;
    private double quatity;
    private Object detail;
    private Object image;
    private boolean status;
    private Date orderDate;
    private boolean checkoutStatus;
    private Object deliveryTracking;

    private ProductOrderDetailResponse product;
    private OrderResponse order;

    public OrderDetailResponse(){}

    public OrderDetailResponse(int id, String itemId, double quatity, Object detail, Object image, boolean status, Date orderDate, boolean checkoutStatus, Object deliveryTracking, ProductOrderDetailResponse product, OrderResponse order) {
        this.id = id;
        this.itemId = itemId;
        this.quatity = quatity;
        this.detail = detail;
        this.image = image;
        this.status = status;
        this.orderDate = orderDate;
        this.checkoutStatus = checkoutStatus;
        this.deliveryTracking = deliveryTracking;
        this.product = product;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getQuatity() {
        return quatity;
    }

    public void setQuatity(double quatity) {
        this.quatity = quatity;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public Object getDeliveryTracking() {
        return deliveryTracking;
    }

    public void setDeliveryTracking(Object deliveryTracking) {
        this.deliveryTracking = deliveryTracking;
    }

    public ProductOrderDetailResponse getProduct() {
        return product;
    }

    public void setProduct(ProductOrderDetailResponse product) {
        this.product = product;
    }

    public OrderResponse getOrder() {
        return order;
    }

    public void setOrder(OrderResponse order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetailResponse{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", quatity=" + quatity +
                ", detail=" + detail +
                ", image=" + image +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", checkoutStatus=" + checkoutStatus +
                ", delivery tracking=" + deliveryTracking +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
