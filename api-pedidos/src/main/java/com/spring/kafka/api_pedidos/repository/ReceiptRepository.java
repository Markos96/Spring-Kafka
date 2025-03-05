package com.spring.kafka.api_pedidos.repository;

import com.spring.kafka.api_pedidos.data.domain.Receipt;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
