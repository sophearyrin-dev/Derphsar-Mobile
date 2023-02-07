package com.kshrd.derphsar_api.rest.shopreport.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShopReportRequestModel {

    @JsonIgnore
    private int id;
    private Object reasons;
    @JsonIgnore
    private String shop_report_id;
    private int shop_id;

    public ShopReportRequestModel() {
    }

    public ShopReportRequestModel(int id, Object reasons, String shop_report_id, int shop_id) {
        this.id = id;
        this.reasons = reasons;
        this.shop_report_id = shop_report_id;
        this.shop_id = shop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getReasons() {
        return reasons;
    }

    public void setReasons(Object reasons) {
        this.reasons = reasons;
    }

    public String getShop_report_id() {
        return shop_report_id;
    }

    public void setShop_report_id(String shop_report_id) {
        this.shop_report_id = shop_report_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "ShopReportRequestModel{" +
                "id=" + id +
                ", reasons=" + reasons +
                ", shop_report_id='" + shop_report_id + '\'' +
                ", shop_id=" + shop_id +
                '}';
    }
}

