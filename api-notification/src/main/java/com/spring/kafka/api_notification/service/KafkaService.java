package com.spring.kafka.api_notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = "receipt", groupId = "receipt_consumer")
    public void receipt(String message) {
        System.out.println(message);
    }
}
