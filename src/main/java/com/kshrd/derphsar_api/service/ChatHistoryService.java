package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.ChatDto;
import com.kshrd.derphsar_api.repository.dto.ChatHistoryDto;
import com.kshrd.derphsar_api.repository.dto.ChatMessageDto;
import com.kshrd.derphsar_api.repository.dto.ProductDto;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;

import java.util.List;

public interface ChatHistoryService {

    ChatHistoryRequestModel insertChatHistory(ChatHistoryRequestModel chatHistoryRequestModel);

    List<ChatHistoryDto> getChatHistory(int u_id);

    List<ChatDto> getListChatByShopId(int shop_id);

    List<ChatMessageDto> getMessageChatHistory(int u_id);

    List<ChatHistoryDto> getChatWithShopAndUser(int u_id, int shop_id);

    //pheary - find user chat by shopId
    List<ChatDto> findUserChatByShopId(int shopId);
}
