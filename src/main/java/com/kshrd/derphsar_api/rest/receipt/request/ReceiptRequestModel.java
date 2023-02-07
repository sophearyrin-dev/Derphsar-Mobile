package com.kshrd.derphsar_api.rest.receipt.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReceiptRequestModel {
    @JsonIgnore
    private int id;
    private String receipt_url;
    private String receipt_id;
    @JsonIgnore
    private int user_id;

    public ReceiptRequestModel() {
    }

    public ReceiptRequestModel(int id, String receipt_url, String receipt_id, int user_id) {
        this.id = id;
        this.receipt_url = receipt_url;
        this.receipt_id = receipt_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceipt_url() {
        return receipt_url;
    }

    public void setReceipt_url(String receipt_url) {
        this.receipt_url = receipt_url;
    }

    public Object getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(String receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ReceiptRequestModel{" +
                "id=" + id +
                ", receipt_url='" + receipt_url + '\'' +
                ", receipt_id=" + receipt_id +
                ", user_id=" + user_id +
                '}';
    }
}
