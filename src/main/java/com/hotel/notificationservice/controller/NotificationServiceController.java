package com.hotel.notificationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class NotificationServiceController
{
    @GetMapping("get/instance")
    public ResponseEntity<String> getInstance()
    {
        return new ResponseEntity<>("this is Notification Service", HttpStatus.OK);
    }
}