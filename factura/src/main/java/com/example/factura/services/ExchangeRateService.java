package com.example.factura.services;

import com.example.factura.model.ExchangeRate;
import com.example.factura.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;


    public List<ExchangeRate> getAllExchangeRate() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate getExchangeRateById(Integer id) {
        return exchangeRateRepository.findById(id).orElse(null);
    }

    public void addExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);
    }

    public void updateExchangeRate(Integer id, ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);

    }

    public void deleteExchangeRate(Integer id) {
        exchangeRateRepository.deleteById(id);
    }
}
