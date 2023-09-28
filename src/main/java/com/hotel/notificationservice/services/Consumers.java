package com.hotel.notificationservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.notificationservice.entities.AnalyticsDatum;
import com.hotel.notificationservice.entities.FullReserveDtls;
import com.hotel.notificationservice.entities.Notification;
import com.hotel.notificationservice.entities.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;

@Service
public class Consumers {

    private Logger logger = LoggerFactory.getLogger(Consumers.class);

    @Autowired
    NotificationRepository notificationRepository;

    public void consume(String message) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        AnalyticsDatum datum = objectMapper.readValue(message,AnalyticsDatum.class);

        if (datum.getType().equals("Checkout")) {
            logger.info("The message is : " + datum.getMessage());

            FullReserveDtls fullReserveDtls = objectMapper.readValue(datum.getPayload(), FullReserveDtls.class);
            Notification notification = new Notification();
            notification.setNotificationId(String.valueOf((int)(Math.random()*100000)));
            notification.setRecipientPhone(fullReserveDtls.getPhone());
            notification.setRecipientEmail(fullReserveDtls.getEmail());
            notification.setMessage(datum.getMessage());
            notification.setStatus(datum.getType());
            notification.setReservationId(fullReserveDtls.getReservationId());
            notification.setCreatedAt(Instant.now());

            notificationRepository.save(notification);

        } else {
            logger.info("Else Case");
        }
    }
}
