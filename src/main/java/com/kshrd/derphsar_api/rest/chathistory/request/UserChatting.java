package com.kshrd.derphsar_api.rest.chathistory.request;

public class UserChatting {
    private int _id;
    private String name;
    private String avatar;

    public UserChatting() {
    }

    public UserChatting(int _id, String name, String avatar) {
        this._id = _id;
        this.name = name;
        this.avatar = avatar;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @Override
    public String toString() {
        return "UserChatting{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
