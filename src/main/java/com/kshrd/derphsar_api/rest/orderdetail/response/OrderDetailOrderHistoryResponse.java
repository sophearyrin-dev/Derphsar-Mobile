package com.kshrd.derphsar_api.rest.orderdetail.response;

import com.kshrd.derphsar_api.repository.dto.OrderDto;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.rest.product.response.ProducOrderHistorytResponse;

import java.sql.Date;

public class OrderDetailOrderHistoryResponse {
    private String itemId;
    private Date orderDate;
    private double quatity;
    private boolean checkoutStatus;


    private Object detail;
    private Object image;
    private boolean status;
    private int order_id;
    private int pro_id;
    private OrderDto order;
    private Object deliveryTracking;
    private String destination;


    private ProducOrderHistorytResponse product;

    public OrderDetailOrderHistoryResponse() {
    }

    public OrderDetailOrderHistoryResponse(String itemId, Date orderDate, double quatity, boolean checkoutStatus, Object detail, Object image, boolean status, int order_id, int pro_id, OrderDto order, Object deliveryTracking, String destination, ProducOrderHistorytResponse product) {
        this.itemId = itemId;
        this.orderDate = orderDate;
        this.quatity = quatity;
        this.checkoutStatus = checkoutStatus;
        this.detail = detail;
        this.image = image;
        this.status = status;
        this.order_id = order_id;
        this.pro_id = pro_id;
        this.order = order;
        this.deliveryTracking = deliveryTracking;
        this.destination = destination;
        this.product = product;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getQuatity() {
        return quatity;
    }

    public void setQuatity(double quatity) {
        this.quatity = quatity;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public Object getDeliveryTracking() {
        return deliveryTracking;
    }

    public void setDeliveryTracking(Object deliveryTracking) {
        this.deliveryTracking = deliveryTracking;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ProducOrderHistorytResponse getProduct() {
        return product;
    }

    public void setProduct(ProducOrderHistorytResponse product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetailOrderHistoryResponse{" +
                "itemId='" + itemId + '\'' +
                ", orderDate=" + orderDate +
                ", quatity=" + quatity +
                ", checkoutStatus=" + checkoutStatus +
                ", detail=" + detail +
                ", image=" + image +
                ", status=" + status +
                ", order_id=" + order_id +
                ", pro_id=" + pro_id +
                ", order=" + order +
                ", deliveryTracking=" + deliveryTracking +
                ", destination='" + destination + '\'' +
                ", product=" + product +
                '}';
    }
}
