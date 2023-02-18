package com.niit.notificationservice.repository;


import com.niit.notificationservice.domain.Notification;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {


}
