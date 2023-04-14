package com.example.factura.repository;

import com.example.factura.model.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMethodRepository extends JpaRepository<PayMethod, Integer> {
}
