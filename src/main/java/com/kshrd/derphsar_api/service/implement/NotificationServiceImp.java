package com.kshrd.derphsar_api.service.implement;

import com.kshrd.derphsar_api.repository.NotificationRepository;
import com.kshrd.derphsar_api.repository.dto.NotificationDto;
import com.kshrd.derphsar_api.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImp implements NotificationService {

    private NotificationRepository notificationRepository;


    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDto insertNotification(NotificationDto notificationDto) {
        boolean isInserted = notificationRepository.insertNotification(notificationDto);

        if(isInserted)
            return notificationDto;
        else
            return null;
    }

    @Override
    public NotificationDto getNotiByReceiverId(String receiver_id) {
        return notificationRepository.getNotiByReceiverId(receiver_id);
    }

    @Override
    public boolean updateNotificationById(int id) {
        boolean isUpdated = notificationRepository.updateNotificationById(id);
        return isUpdated;
    }
}
