package com.niit.notificationservice.controller;

import com.niit.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class NotificationController {
    private NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications/{userId}")
    public ResponseEntity<?> notifications(@PathVariable String userId){
//        Claims claims = (Claims) request.getAttribute("claims");
//        String email = claims.getSubject();
//        System.out.println("user email from claims(notification) :: " + claims.getSubject());
//        System.out.println("email " + email);
        return new ResponseEntity<>(notificationService.getNotification(userId),HttpStatus.OK);
    }
}
