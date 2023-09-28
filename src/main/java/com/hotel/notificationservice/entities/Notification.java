package com.hotel.notificationservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @Column(name = "notification_id", nullable = false, length = 50)
    private String notificationId;

    @Column(name = "recipient_phone", length = 10)
    private String recipientPhone;

    @Column(name = "recipient_email")
    private String recipientEmail;

    @Column(name = "message")
    private String message;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "created_at")
    private Instant createdAt;

}