package com.spring.kafka.api_pedidos.data.dao;

import com.spring.kafka.api_pedidos.data.domain.Receipt;
import com.spring.kafka.api_pedidos.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptDAO {
    private ReceiptRepository receiptRepository;

    public Receipt saveReceipt(Receipt receipt) {
        return this.receiptRepository.save(receipt);
    }

    @Autowired
    public void setReceiptRepository(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }
}
