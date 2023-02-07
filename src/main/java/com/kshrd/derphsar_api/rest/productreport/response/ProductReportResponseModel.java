package com.kshrd.derphsar_api.rest.productreport.response;

public class ProductReportResponseModel {

    private int id;
    private String report_id;
    private String comment;
    private int pro_id;

    public ProductReportResponseModel() {
    }

    public ProductReportResponseModel(int id, String report_id, String comment, int pro_id) {
        this.id = id;
        this.report_id = report_id;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "ProductReportResponseModel{" +
                "id=" + id +
                ", report_id='" + report_id + '\'' +
                ", comment='" + comment + '\'' +
                ", pro_id=" + pro_id +
                '}';
    }
}
