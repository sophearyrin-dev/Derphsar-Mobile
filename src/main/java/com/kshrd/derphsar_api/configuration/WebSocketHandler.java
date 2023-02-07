package com.kshrd.derphsar_api.configuration;

import com.google.gson.Gson;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel1;
import com.kshrd.derphsar_api.service.implement.ChatHistoryServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j

public class WebSocketHandler extends TextWebSocketHandler {
    private Set<WebSocketSession> activeSessions = new HashSet<>();
    private ChatHistoryServiceImp chatHistoryServiceImp;

    @Autowired
    public void setChatHistoryServiceImp(ChatHistoryServiceImp chatHistoryServiceImp) {
        this.chatHistoryServiceImp = chatHistoryServiceImp;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("New WebSocket connection with id: " + session.getId());
        activeSessions = Stream.concat(activeSessions.stream(), Stream.of(session))
                .collect(Collectors.toSet());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        activeSessions = activeSessions.stream()
                .filter(s -> !session.equals(s))
                .collect(Collectors.toSet());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        Gson g = new Gson();
        ChatHistoryRequestModel1 model1 = g.fromJson(message.getPayload(), ChatHistoryRequestModel1.class);

        System.out.println("message : " + message.getPayload());
        System.out.println("chat: " + model1);


        ChatHistoryRequestModel chatHistoryRequestModel = new ChatHistoryRequestModel();
        chatHistoryRequestModel.setU_id(model1.getUser().get_id());
        chatHistoryRequestModel.setMessage(model1.getText());
        chatHistoryRequestModel.setCreate_at(model1.getCreatedAt());
        chatHistoryRequestModel.setImage(model1.getImage());
        chatHistoryRequestModel.setShop_id(model1.get_id());
        chatHistoryRequestModel.setSender_id(model1.getSender_id());
        chatHistoryServiceImp.insertChatHistory(chatHistoryRequestModel);

        activeSessions.forEach((ses) -> {

            try {
                ses.sendMessage(message);
            } catch (Exception ex) {
                System.out.println("Couldn't send WebSocket message to session with id: " + session.getId());
            }
        });
    }
}

