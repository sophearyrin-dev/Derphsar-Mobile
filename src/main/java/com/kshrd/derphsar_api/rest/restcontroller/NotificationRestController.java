package com.kshrd.derphsar_api.rest.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kshrd.derphsar_api.repository.dto.NotificationDto;
import com.kshrd.derphsar_api.repository.dto.OrderDetailDto;
import com.kshrd.derphsar_api.rest.message.MessageProperties;
import com.kshrd.derphsar_api.rest.notification.request.NotificationRequestModel;
import com.kshrd.derphsar_api.rest.notification.response.NotificationResponseModel;
import com.kshrd.derphsar_api.rest.orderdetail.request.OrderDetailUpdateDeliveryTrackingModel;
import com.kshrd.derphsar_api.rest.orderdetail.response.OrderDetailResponse;
import com.kshrd.derphsar_api.rest.utils.BaseApiNoPaginationResponse;
import com.kshrd.derphsar_api.service.implement.NotificationServiceImp;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class NotificationRestController {


    private NotificationServiceImp notificationServiceImp;
    private MessageProperties message;


    @Autowired
    public void setNotificationServiceImp(NotificationServiceImp notificationServiceImp) {
        this.notificationServiceImp = notificationServiceImp;
    }

    @Autowired
    public void setMessage(MessageProperties message) {
        this.message = message;
    }

    /**
     * Post notification
     * @param notificationRequestModel
     * @return
     */
    @PostMapping("/post-notification")
    @ApiOperation(value = "post notification", response = NotificationResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<NotificationResponseModel>> createProduct(
            @RequestBody NotificationRequestModel notificationRequestModel) {

        BaseApiNoPaginationResponse<NotificationResponseModel> response = new BaseApiNoPaginationResponse<>();
        ModelMapper mapper = new ModelMapper();

        NotificationDto notificationDto = mapper.map(notificationRequestModel, NotificationDto.class);

        if(!notificationRequestModel.getSender_id().isEmpty()){

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            notificationDto.setTimestamp(timestamp);


            NotificationDto result = notificationServiceImp.insertNotification(notificationDto);
            NotificationResponseModel responseModel = mapper.map(result, NotificationResponseModel.class);
            response.setMessage(message.inserted("Notification"));
            response.setData(responseModel);
            response.setStatus(HttpStatus.CREATED);

        }else {
            response.setMessage(message.insertError("Notification"));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    //Get Notification
    @GetMapping("/get-notificatoin/{receiver_id}")
    @ApiOperation(value = "Get Notification by receiver_id", response = NotificationResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse <NotificationResponseModel>> findById(@PathVariable("receiver_id") String receiver_id){

        BaseApiNoPaginationResponse <NotificationResponseModel> response = new BaseApiNoPaginationResponse<>();
        ObjectMapper objectMapper = new ObjectMapper();
        NotificationDto notificationDto = notificationServiceImp.getNotiByReceiverId(receiver_id);

        try {

            Object noti = objectMapper.readValue(notificationDto.getNoti().toString(), Object.class);
            notificationDto.setNoti(noti);

            ModelMapper modelMapper = new ModelMapper();
            NotificationResponseModel productResponseModel = modelMapper .map(notificationDto, NotificationResponseModel.class);

            if(notificationDto != null){
                response.setData(productResponseModel);
                response.setMessage(message.selected("Notification"));
                response.setStatus(HttpStatus.OK);
            }else {
                response.setMessage(message.hasNoRecord("Notification"));
                response.setStatus(HttpStatus.BAD_REQUEST);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //update notification by id
    @PatchMapping("/update-notification/{id}")
    @ApiOperation(value = "update notification by id", response = NotificationResponseModel.class)
    public ResponseEntity<BaseApiNoPaginationResponse<NotificationResponseModel>> updateNotificationById(
            @PathVariable("id") int id){

        BaseApiNoPaginationResponse<NotificationResponseModel> response = new BaseApiNoPaginationResponse <>();
        ModelMapper modelMapper = new ModelMapper();

        try {
            NotificationResponseModel responseModel = modelMapper.map(notificationServiceImp.updateNotificationById(id),NotificationResponseModel.class);
            response.setMessage(message.updated("Notification"));
            response.setStatus(HttpStatus.OK);
            response.setData(responseModel);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


}
