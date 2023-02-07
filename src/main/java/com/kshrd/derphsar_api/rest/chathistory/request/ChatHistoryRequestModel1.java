package com.kshrd.derphsar_api.rest.chathistory.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kshrd.derphsar_api.repository.dto.UserDto;

import java.util.Date;

public class ChatHistoryRequestModel1 {
    @JsonIgnore
    private int _id;
    private Date createdAt;
    private String text;
    private String image;
    private UserChatting user;
    private int sender_id;

    public ChatHistoryRequestModel1() {
    }

    public ChatHistoryRequestModel1(int _id, Date createdAt, String text, String image, UserChatting user, int sender_id) {
        this._id = _id;
        this.createdAt = createdAt;
        this.text = text;
        this.image = image;
        this.user = user;
        this.sender_id = sender_id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserChatting getUser() {
        return user;
    }

    public void setUser(UserChatting user) {
        this.user = user;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    @Override
    public String toString() {
        return "ChatHistoryRequestModel1{" +
                "_id=" + _id +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", sender_id=" + sender_id +
                '}';
    }
}


