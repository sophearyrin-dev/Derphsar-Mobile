package com.kshrd.derphsar_api.repository.dto;

public class ShopReportDto {
    private int id;
    private String shop_report_id;
    private Object reasons;
    private int shop_id;

    public ShopReportDto() {
    }

    public ShopReportDto(int id, String shop_report_id, Object reasons, int shop_id) {
        this.id = id;
        this.shop_report_id = shop_report_id;
        this.reasons = reasons;
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

    public Object getReasons() {
        return reasons;
    }

    public void setReasons(Object reasons) {
        this.reasons = reasons;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "ShopReportDto{" +
                "id=" + id +
                ", shop_report_id='" + shop_report_id + '\'' +
                ", reasons=" + reasons +
                ", shop_id=" + shop_id +
                '}';
    }
}
