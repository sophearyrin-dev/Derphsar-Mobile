package com.kshrd.derphsar_api.rest.chathistory.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class ChatHistoryRequestModel {
    @JsonIgnore
    private int chat_message_id;
    private int u_id;
    private int shop_id;
    private Date create_at;
    private String message;
    private String image;

    private int sender_id;

    public ChatHistoryRequestModel() {
    }

    public ChatHistoryRequestModel(int chat_message_id, int u_id, int shop_id, Date create_at, String message, String image, int sender_id) {
        this.chat_message_id = chat_message_id;
        this.u_id = u_id;
        this.shop_id = shop_id;
        this.create_at = create_at;
        this.message = message;
        this.image = image;
        this.sender_id = sender_id;
    }

    public int getChat_message_id() {
        return chat_message_id;
    }

    public void setChat_message_id(int chat_message_id) {
        this.chat_message_id = chat_message_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    @Override
    public String toString() {
        return "ChatHistoryRequestModel{" +
                "chat_message_id=" + chat_message_id +
                ", u_id=" + u_id +
                ", shop_id=" + shop_id +
                ", create_at=" + create_at +
                ", message='" + message + '\'' +
                ", image='" + image + '\'' +
                ", sender_id=" + sender_id +
                '}';
    }
}
