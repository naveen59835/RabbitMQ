package com.niit.notificationservice.service;


import com.niit.notificationservice.config.ProductDTO;
import com.niit.notificationservice.domain.Notification;
import com.niit.notificationservice.repository.NotificationRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification getNotification(String userId) {
        return notificationRepository.findById(userId).get();
    }

    @RabbitListener(queues = "direct-Queue")
    @Override
    public void saveNotifications(ProductDTO productDTO) {
        Notification notification=new Notification();
        String userId=productDTO.getJsonObject().get("userId").toString();
        if(notificationRepository.findById(userId).isEmpty())
        {
            notification.setUserId(userId);
        }
        notification.setNotificationMessage("The product is not in stock");
        notification.setProductNames(productDTO.getJsonObject());
        notificationRepository.save(notification);
    }
}

