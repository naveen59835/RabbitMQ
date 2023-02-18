package com.niit.notificationservice.domain;


import lombok.*;
import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document
public class Notification {
    @Id
    private String userId;
    private String notificationMessage;

    JSONObject productNames;

}





