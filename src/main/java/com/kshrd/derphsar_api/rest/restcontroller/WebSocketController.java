package com.kshrd.derphsar_api.rest.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1")
public class WebSocketController {

    @RequestMapping("/chat")
    public String getWebSocket(){
        return "ws://192.168.0.181:8080/chat";
    }
}
