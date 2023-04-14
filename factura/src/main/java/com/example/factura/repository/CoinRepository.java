package com.example.factura.repository;

import com.example.factura.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Integer> {
}
