package com.example.factura.repository;


import com.example.factura.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository  extends JpaRepository<ExchangeRate, Integer> {
}
