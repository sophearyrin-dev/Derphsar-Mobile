package com.kshrd.derphsar_api.repository.provider;

import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;
import org.apache.ibatis.jdbc.SQL;

public class ChatHistoryProvider {

    //save chat history to db

    public String insertChatHistory(ChatHistoryRequestModel chatHistoryRequestModel){
        return new SQL(){{
            INSERT_INTO("dp_chat_history");
            VALUES("shop_id, u_id, message, create_at, image, sender_id", "#{shop_id}, #{u_id}, #{message}, #{create_at}, #{image}, #{sender_id}");
        }}.toString();
    }

    //get all chat history

    public String getAllChatHistory(){
        return new SQL(){{
           SELECT("DISTINCT shop_id");
           FROM("dp_chat_history");
           WHERE("u_id = #{u_id}");
        }}.toString();
    }


    //get all message history

    public String getAllMessageChatHistory(){
        return new SQL(){{
            SELECT("*");
            FROM("dp_chat_history");
            WHERE("u_id = #{u_id}");
        }}.toString();
    }


    // get Private chat with shop and user

    public String getChatWithShopAndUser(int u_id, int shop_id){
        return new SQL(){{
            SELECT("*");
            FROM("dp_chat_history");
            WHERE("u_id = #{u_id} AND shop_id = #{shop_id}");
        }}.toString();
    }

    // get chat by shop id

    public String getListChatByShopId(int shop_id){
        return new SQL(){{
            SELECT("*");
            FROM("dp_chat_history");
            WHERE("shop_id = #{shop_id}");
        }}.toString();
    }

    public String getUserByShopId(int shop_id){
        return new SQL(){{
            SELECT("*");
            FROM("dp_chat_history");
            WHERE("shop_id = #{shop_id}");
        }}.toString();
    }
}
