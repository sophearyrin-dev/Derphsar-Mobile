package com.kshrd.derphsar_api.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReceiptDto {
    @JsonIgnore
    private int id;
//    @JsonIgnore
    private String receipt_id;
    private String url;
    @JsonIgnore
    private boolean status;
    private int u_id;

    public ReceiptDto() {
    }

    public ReceiptDto(int id, String receipt_id, String url, boolean status, int u_id) {
        this.id = id;
        this.receipt_id = receipt_id;
        this.url = url;
        this.status = status;
        this.u_id = u_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "ReceiptDto{" +
                "id=" + id +
                ", receipt_id='" + receipt_id + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", u_id=" + u_id +
                '}';
    }
}
