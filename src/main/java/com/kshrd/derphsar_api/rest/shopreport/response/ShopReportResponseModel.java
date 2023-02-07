package com.kshrd.derphsar_api.rest.shopreport.response;

public class ShopReportResponseModel {

    private int id;
    private String shop_report_id;
    private String comment;
    private int shop_id;

    public ShopReportResponseModel(int id, String shop_report_id, String comment, int shop_id) {
        this.id = id;
        this.shop_report_id = shop_report_id;
        this.comment = comment;
        this.shop_id = shop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShop_report_id() {
        return shop_report_id;
    }

    public void setShop_report_id(String shop_report_id) {
        this.shop_report_id = shop_report_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "shopReportResponseModel{" +
                "id=" + id +
                ", shop_report_id='" + shop_report_id + '\'' +
                ", comment='" + comment + '\'' +
                ", shop_id=" + shop_id +
                '}';
    }
}
