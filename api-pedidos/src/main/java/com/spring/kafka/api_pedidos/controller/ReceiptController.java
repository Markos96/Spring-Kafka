package com.spring.kafka.api_pedidos.controller;

import com.spring.kafka.api_pedidos.data.domain.Receipt;
import com.spring.kafka.api_pedidos.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<Receipt> saveReceipt(@RequestBody Receipt receipt) {
        return ResponseEntity.ok().body(this.receiptService.saveReceipt(receipt));
    }

    @Autowired
    public void setReceiptService(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }
}
