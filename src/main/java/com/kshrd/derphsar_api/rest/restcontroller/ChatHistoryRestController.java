package com.kshrd.derphsar_api.rest.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshrd.derphsar_api.page.Pagination;
import com.kshrd.derphsar_api.repository.dto.*;
import com.kshrd.derphsar_api.rest.BaseApiResponse;
import com.kshrd.derphsar_api.rest.chathistory.request.ChatHistoryRequestModel;
import com.kshrd.derphsar_api.rest.chathistory.response.ChatHistoryResponseModel;
import com.kshrd.derphsar_api.rest.follower.response.FollowerResponseModel2;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.product.response.ProductResponseModel;
import com.kshrd.derphsar_api.service.implement.ChatHistoryServiceImp;
import com.kshrd.derphsar_api.service.implement.ShopServiceImp;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ChatHistoryRestController {

    private ChatHistoryServiceImp chatHistoryServiceImp;
    private ShopServiceImp shopServiceImp;
    private MessageProperties message;

    @Autowired
    public void setChatHistoryServiceImp(ChatHistoryServiceImp chatHistoryServiceImp) {
        this.chatHistoryServiceImp = chatHistoryServiceImp;
    }

    @Autowired
    public void setMessage(MessageProperties message) {
        this.message = message;
    }

    @Autowired
    public void setShopServiceImp(ShopServiceImp shopServiceImp) {
        this.shopServiceImp = shopServiceImp;
    }

    /**
     * save chat history to db
     *
     * @param chatHistoryRequestModel - chat history request model
     * @return - Return response message
     */


    @PostMapping("/insertChatHistory")
    @ApiOperation(value = "Insert Chat History", response = ChatHistoryResponseModel.class)
    @ResponseStatus(HttpStatus.CREATED)

    public Map<String, Object> insertChatHistory(@RequestBody ChatHistoryRequestModel chatHistoryRequestModel) {
        Map<String, Object> result = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        chatHistoryServiceImp.insertChatHistory(chatHistoryRequestModel);
        result.put("Message", "Insert Chat History successful");
        result.put("DATA", chatHistoryRequestModel);
        return result;
    }

    /**
     * get all chat history
     *
     * @param u_id
     * @return - Return response message
     */


    @GetMapping("/chatHistory")
    @ApiOperation(value = "Get all shop used to chat", response = ChatHistoryResponseModel.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllShopsChatHistoryUserId(@RequestParam int u_id){
        Map<String, Object> res = new HashMap<>();
        List<ChatHistoryDto> chatDtos = chatHistoryServiceImp.getChatHistory(u_id);
        try {
            if(chatDtos.isEmpty()){
                res.put("Message", "No Chat History in Database");
            }else {
                res.put("Message", "Get Chat History Successful");
            }
            res.put("Data", chatDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    @GetMapping("/GetListChatShopId")
    @ApiOperation(value = "Get List Chat by shop Id", response = ChatHistoryResponseModel.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getListChatByShopId(@RequestParam int shop_id){
        Map<String, Object> res = new HashMap<>();
        List<ChatDto> chatDtos = chatHistoryServiceImp.getListChatByShopId(shop_id);
        try {
            if(chatDtos.isEmpty()){
                res.put("Message", "No List Chat By shop id in Database");
            }else {
                res.put("Message", "Get List Chat By shop id Successful");
            }
            res.put("Data", chatDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    /**
     * get all chat history
     *
     * @param u_id
     * @return - Return response message
     */


    @GetMapping("/chatMessageHistory")
    @ApiOperation(value = "Get all messages chat by user id", response = ChatHistoryResponseModel.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllMessageChatHistoryUserId(@RequestParam int u_id){
        Map<String, Object> res = new HashMap<>();
        List<ChatMessageDto> chatMessageDtos = chatHistoryServiceImp.getMessageChatHistory(u_id);
        try {
            if(chatMessageDtos.isEmpty()){
                res.put("Message", "No Chat Message History in Database");
            }else {
                res.put("Message", "Get Chat Message History Successful");
            }
            res.put("Data", chatMessageDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    //get private chat with shop and user

    @GetMapping("/chat/{shopId and userId}")
    @ApiOperation(value = "get private chat with shop and user", response = ChatHistoryResponseModel.class)
    public Map<String, Object> getOnlyOneChatWithShopAndUser(@RequestParam int u_id, int shop_id){
        Map<String, Object> res = new HashMap<>();

        List<ChatHistoryDto> chatHistoryDtos = chatHistoryServiceImp.getChatWithShopAndUser(u_id, shop_id);

        try {
            if(chatHistoryDtos.isEmpty()){
                res.put("Message", "No Chat with shop and user in shop in Database");
            }else {
                res.put("Message", "Get Chat with shop and user Successful");
            }
            res.put("Data", chatHistoryDtos);

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    //phaery
    @GetMapping("get-user-chat/{shopId}")
    @ApiOperation(value = "get user chat", response = ChatHistoryResponseModel.class)
    public ResponseEntity<BaseApiResponse<List<ChatHistoryResponseModel>>> getUserChatByShopId(@PathVariable("shopId") String shopId) {

        BaseApiResponse<List<ChatHistoryResponseModel>> response = new BaseApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        List<ChatHistoryResponseModel> productResponseModels = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ShopDto shopDto = shopServiceImp.findById(shopId);
            List<ChatDto> products = chatHistoryServiceImp.findUserChatByShopId(shopDto.getId());
            for (ChatDto productDto : products) {

//                Object images = objectMapper.readValue(productDto.getImages().toString(), Object.class);
//                productDto.setImages(images);

                ChatHistoryResponseModel productResponseModel = mapper.map(productDto, ChatHistoryResponseModel.class);
                productResponseModels.add(productResponseModel);
            }

            if (!products.isEmpty()) {
                response.setData(productResponseModels);
                response.setStatus(HttpStatus.FOUND);
                response.setMessage(message.selected("Products"));
            }else {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setMessage(message.hasNoRecords("Products"));
            }

            System.out.println("Product = " + response);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

}
