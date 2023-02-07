package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.repository.provider.ChatHistoryProvider;
import com.kshrd.derphsar_api.repository.provider.FollowerProvider;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatHistoryRepository {

    @InsertProvider(type = ChatHistoryProvider.class, method = "insertChatHistory")
    Boolean insertChatHistory(ChatHistoryRequestModel chatHistoryRequestModel);


    @SelectProvider(value = ChatHistoryProvider.class, method = "getAllChatHistory")
    @Results(id = "mapShop", value = {
            @Result(column = "shop_id", property = "shopDto", many = @Many(select = "getShop"))
    })
    List<ChatHistoryDto> getAllChatHistory(int u_id);


    @SelectProvider(value = ChatHistoryProvider.class, method = "getListChatByShopId")
    @Results(id= "shopMap", value = {
            @Result(column = "u_id", property = "user", many = @Many(select = "getUser")),
    })
    List<ChatDto> getListChatByShopId(int shop_id);


    @SelectProvider(value = ChatHistoryProvider.class, method = "getAllMessageChatHistory")
    List<ChatMessageDto> getAllMessageChatHistory(int u_id);


    @Select("SELECT * FROM dp_shops WHERE id = #{shop_id}")
    @Results({
            @Result(column = "shop_id" ,property = "shopId"),
    })
    ShopDto getShop(int shop_id);


    @SelectProvider(value = ChatHistoryProvider.class, method = "getChatWithShopAndUser")
    @Results({
            @Result(property = "u_id", column = "u_id"),
            @Result(property = "shop_id", column = "shop_id"),
    })
    List<ChatHistoryDto> getChatWithShopAndUser(int u_id, int shop_id);

    //pheary
    @Select("SELECT DISTINCT u_id FROM dp_chat_history WHERE shop_id=#{shopId}")
    @Results(id = "chatMap2", value = {
            @Result(column = "u_id" ,property = "user",many = @Many(select = "getUser")),
    })
    List<ChatDto> findChatByShopId(@Param("shopId") int shopId);

    @Select("SELECT * FROM dp_users WHERE id = #{user_id}  AND status = 'true'")
    @Results({
            @Result(column = "user_id", property = "userId")
    })
    UserDto getUser(int user_id);
}
