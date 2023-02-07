package com.kshrd.derphsar_api.rest.chathistory.response;

import com.kshrd.derphsar_api.rest.user.response.UserResponseModel;

public class ChatHistoryResponseModel {
    private int chat_message_id;
    private int u_id;

    private String message;
    private String image;

    private int sender_id;
    private int shop_id;

    private UserResponseModel user;

    public ChatHistoryResponseModel() {

    }

    public ChatHistoryResponseModel(int chat_message_id, int u_id, String message, String image, int sender_id, int shop_id, UserResponseModel user) {
        this.chat_message_id = chat_message_id;
        this.u_id = u_id;
        this.message = message;
        this.image = image;
        this.sender_id = sender_id;
        this.shop_id = shop_id;
        this.user = user;
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

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public UserResponseModel getUser() {
        return user;
    }

    public void setUser(UserResponseModel user) {
        this.user = user;
    }

}
