package com.kshrd.derphsar_api.rest.orderdetail.request;

import java.util.Arrays;

public class OrderDetailUpdateIsCheckoutModel {
    private String[] orderItemId;

    public OrderDetailUpdateIsCheckoutModel() {
    }

    public OrderDetailUpdateIsCheckoutModel(String[] orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String[] getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String[] orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Override
    public String toString() {
        return "OrderDetailUpdateIsCheckoutModel{" +
                "orderItemId=" + Arrays.toString(orderItemId) +
                '}';
    }
}
