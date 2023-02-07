package com.kshrd.derphsar_api.rest.orderdetail.request;

public class OrderDetailUpdateDeliveryTrackingModel {

    private Object deliveryTracking;

    public OrderDetailUpdateDeliveryTrackingModel() {
    }

    public OrderDetailUpdateDeliveryTrackingModel(Object deliveryTracking) {
        this.deliveryTracking = deliveryTracking;
    }

    public Object getDeliveryTracking() {
        return deliveryTracking;
    }

    public void setDeliveryTracking(Object deliveryTracking) {
        this.deliveryTracking = deliveryTracking;
    }

    @Override
    public String toString() {
        return "OrderDetailUpdateDeliveryTracking{" +
                "deliveryTracking=" + deliveryTracking +
                '}';
    }
}
