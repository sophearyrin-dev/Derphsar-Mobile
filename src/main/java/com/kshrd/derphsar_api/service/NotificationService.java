package com.kshrd.derphsar_api.service;

import com.kshrd.derphsar_api.repository.dto.NotificationDto;
import com.kshrd.derphsar_api.repository.dto.ProductDto;

public interface NotificationService {

    //post notification
    NotificationDto insertNotification(NotificationDto notificationDto);

    //get notification by receiver_id
    NotificationDto getNotiByReceiverId(String receiver_id);

    //update a notification by id
    boolean updateNotificationById(int id);
}
