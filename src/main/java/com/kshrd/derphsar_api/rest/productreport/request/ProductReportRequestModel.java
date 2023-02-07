package com.kshrd.derphsar_api.rest.productreport.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductReportRequestModel {

    @JsonIgnore
    private int id;
    @JsonIgnore
    private String report_id;
    private Object reasons;
    private int pro_id;

    public ProductReportRequestModel() {
    }

    public ProductReportRequestModel(int id, String report_id, Object reasons, int pro_id) {
        this.id = id;
        this.report_id = report_id;
        this.reasons = reasons;
        this.pro_id = pro_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public Object getReasons() {
        return reasons;
    }

    public void setReasons(Object reasons) {
        this.reasons = reasons;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "ProductReportRequestModel{" +
                "id=" + id +
                ", report_id='" + report_id + '\'' +
                ", reasons=" + reasons +
                ", pro_id=" + pro_id +
                '}';
    }
}
