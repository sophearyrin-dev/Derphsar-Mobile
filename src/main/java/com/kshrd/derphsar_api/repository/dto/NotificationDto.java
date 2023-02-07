package com.kshrd.derphsar_api.repository.dto;

import java.sql.Timestamp;

public class NotificationDto {

    private int id;
    private String sender_id;
    private String receiver_id;
    private Object noti;
    private String noti_type;
    private String role_sender;
    private Timestamp timestamp;
    private boolean is_read;

    public NotificationDto() {
    }

    public NotificationDto(int id, String sender_id, String receiver_id, Object noti, String noti_type, String role_sender, Timestamp timestamp, boolean is_read) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.noti = noti;
        this.noti_type = noti_type;
        this.role_sender = role_sender;
        this.timestamp = timestamp;
        this.is_read = is_read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Object getNoti() {
        return noti;
    }

    public void setNoti(Object noti) {
        this.noti = noti;
    }

    public String getNoti_type() {
        return noti_type;
    }

    public void setNoti_type(String noti_type) {
        this.noti_type = noti_type;
    }

    public String getRole_sender() {
        return role_sender;
    }

    public void setRole_sender(String role_sender) {
        this.role_sender = role_sender;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    @Override
    public String toString() {
        return "NotificationDto{" +
                "id=" + id +
                ", sender_id='" + sender_id + '\'' +
                ", receiver_id='" + receiver_id + '\'' +
                ", noti=" + noti +
                ", noti_type='" + noti_type + '\'' +
                ", role_sender='" + role_sender + '\'' +
                ", timestamp" + timestamp +
                ", is_read=" + is_read +
                '}';
    }
}
