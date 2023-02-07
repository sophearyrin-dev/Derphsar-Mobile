package com.kshrd.derphsar_api.rest.receipt.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;

import java.util.List;

public class ReceiptResponseModel {
    private int id;
    private String receipt_url;
    private int receipt_id;
    private int user_id;
    private String status;
    private List<UserResponseModel> userResponseModels;

    public ReceiptResponseModel() {
    }

    public ReceiptResponseModel(int id, String receipt_url, int receipt_id, int user_id, String status, List<UserResponseModel> userResponseModels) {
        this.id = id;
        this.receipt_url = receipt_url;
        this.receipt_id = receipt_id;
        this.user_id = user_id;
        this.status = status;
        this.userResponseModels = userResponseModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getReceipt_url() {
        return receipt_url;
    }

    public void setReceipt_url(String receipt_url) {
        this.receipt_url = receipt_url;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserResponseModel> getUserResponseModels() {
        return userResponseModels;
    }

    public void setUserResponseModels(List<UserResponseModel> userResponseModels) {
        this.userResponseModels = userResponseModels;
    }

    @Override
    public String toString() {
        return "ReceiptResponseModel{" +
                "id=" + id +
                ", receipt_url=" + receipt_url +
                ", receipt_id=" + receipt_id +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                ", userResponseModels=" + userResponseModels +
                '}';
    }
}