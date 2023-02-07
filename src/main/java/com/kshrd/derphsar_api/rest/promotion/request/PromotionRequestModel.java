package com.kshrd.derphsar_api.rest.promotion.request;

import java.sql.Date;

public class PromotionRequestModel {

    private String title;
    private boolean isApply;
    private Date startDate;
    private Date endDate;
    private String cover;
    private double startRank;
    private double endRank;
    private boolean status;
    private int u_id;

    public PromotionRequestModel() {
    }

    public PromotionRequestModel(String title, boolean isApply, Date startDate, Date endDate, String cover, double startRank, double endRank, boolean status, int u_id) {
        this.title = title;
        this.isApply = isApply;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cover = cover;
        this.startRank = startRank;
        this.endRank = endRank;
        this.status = status;
        this.u_id = u_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public double getStartRank() {
        return startRank;
    }

    public void setStartRank(double startRank) {
        this.startRank = startRank;
    }

    public double getEndRank() {
        return endRank;
    }

    public void setEndRank(double endRank) {
        this.endRank = endRank;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "PromotionRequestModel{" +
                "title='" + title + '\'' +
                ", isApply=" + isApply +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cover='" + cover + '\'' +
                ", startRank=" + startRank +
                ", endRank=" + endRank +
                ", status=" + status +
                ", u_id=" + u_id +
                '}';
    }
}
