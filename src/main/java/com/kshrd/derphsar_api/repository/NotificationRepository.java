package com.kshrd.derphsar_api.repository;

import com.kshrd.derphsar_api.repository.dto.NotificationDto;
import com.kshrd.derphsar_api.repository.dto.OrderDetailDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository {

    //insert notification
    @Insert("INSERT INTO dp_notification (sender_id, receiver_id, noti, noti_type, role_sender)" +
            "VALUES (#{sender_id}, #{receiver_id}, #{noti, jdbcType=OTHER, typeHandler=com.kshrd.derphsar_api.mybatis.JSONTypeHandlerPg}, #{noti_type}, #{role_sender})")
    boolean insertNotification(NotificationDto notificationDto);

    //get notification by receiver_id
    @Select("SELECT * FROM dp_notification as n WHERE n.receiver_id=#{receiver_id}")
    NotificationDto getNotiByReceiverId(@Param("receiver_id") String receiver_id);

    //update notification by id
    @Update("UPDATE dp_notification SET is_read='TRUE' where id=#{id}")
    boolean updateNotificationById(int id);


}
