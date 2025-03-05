package com.spring.kafka.api_pedidos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.kafka.api_pedidos.data.dao.ReceiptDAO;
import com.spring.kafka.api_pedidos.data.domain.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    private ReceiptDAO receiptDAO;
    private KafkaService kafkaService;
    private ObjectMapper objectMapper;


    public Receipt saveReceipt(Receipt receipt) {
        Receipt receiptSaved = receiptDAO.saveReceipt(receipt);
        String message = convertReceiptToJson(receiptSaved);
        kafkaService.sendMessage(message);

        return receiptSaved;
    }

    private String convertReceiptToJson(Receipt receipt) {
        try {
            return objectMapper.writeValueAsString(receipt);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    @Autowired
    public void setReceiptDAO(ReceiptDAO receiptDAO) {
        this.receiptDAO = receiptDAO;
    }

    @Autowired
    public void setKafkaService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
