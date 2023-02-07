package com.kshrd.derphsar_api.repository.dto;

public class ChatHistoryDto {
    private int chat_message_id;
    private int u_id;
    private int shop_id;
    private String message;
    private String Create_at;
    private String image;

    private ShopDto shopDto;
    private int sender_id;


    public ChatHistoryDto() {
    }

    public ChatHistoryDto(int chat_message_id, int u_id, int shop_id, String message, String create_at, String image, ShopDto shopDto, int sender_id) {
        this.chat_message_id = chat_message_id;
        this.u_id = u_id;
        this.shop_id = shop_id;
        this.message = message;
        Create_at = create_at;
        this.image = image;
        this.shopDto = shopDto;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreate_at() {
        return Create_at;
    }

    public void setCreate_at(String create_at) {
        Create_at = create_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ShopDto getShopDto() {
        return shopDto;
    }

    public void setShopDto(ShopDto shopDto) {
        this.shopDto = shopDto;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    @Override
    public String toString() {
        return "ChatHistoryDto{" +
                "chat_message_id=" + chat_message_id +
                ", u_id=" + u_id +
                ", shop_id=" + shop_id +
                ", message='" + message + '\'' +
                ", Create_at='" + Create_at + '\'' +
                ", image='" + image + '\'' +
                ", shopDto=" + shopDto +
                ", sender_id=" + sender_id +
                '}';
    }
}
