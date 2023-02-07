package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.ChatHistoryRepository;
import com.kshrd.derphsar_api.repository.dto.ChatDto;
import com.kshrd.derphsar_api.repository.dto.ChatHistoryDto;
import com.kshrd.derphsar_api.repository.dto.ChatMessageDto;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;
import com.kshrd.derphsar_api.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryServiceImp implements ChatHistoryService {

    private ChatHistoryRepository chatHistoryRepository;

    @Autowired
    public void setChatHistoryRepository(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    @Override
    public ChatHistoryRequestModel insertChatHistory(ChatHistoryRequestModel chatHistoryRequestModel) {
        boolean isInserted = chatHistoryRepository.insertChatHistory(chatHistoryRequestModel);
        if (isInserted)
            return chatHistoryRequestModel;
        else
            return null;
    }

    @Override
    public List<ChatHistoryDto> getChatHistory(int u_id) {
        return chatHistoryRepository.getAllChatHistory(u_id);
    }

    @Override
    public List<ChatDto> getListChatByShopId(int shop_id) {
        return chatHistoryRepository.getListChatByShopId(shop_id);
    }

    @Override
    public List<ChatMessageDto> getMessageChatHistory(int u_id) {
        return chatHistoryRepository.getAllMessageChatHistory(u_id);
    }

    @Override
    public List<ChatHistoryDto> getChatWithShopAndUser(int u_id, int shop_id) {
        return chatHistoryRepository.getChatWithShopAndUser(u_id, shop_id);
    }

    @Override
    public List<ChatDto> findUserChatByShopId(int shopId) {
        return chatHistoryRepository.findChatByShopId(shopId);
    }
}
