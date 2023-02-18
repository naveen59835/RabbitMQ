package com.niit.notificationservice.service;


import com.niit.notificationservice.config.ProductDTO;

import com.niit.notificationservice.domain.Notification;

public interface NotificationService {
    public Notification getNotification(String userId);
    void saveNotifications(ProductDTO productDTO);
}



