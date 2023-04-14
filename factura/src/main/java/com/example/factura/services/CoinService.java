package com.example.factura.services;

import com.example.factura.model.Coin;
import com.example.factura.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;


    public List<Coin> getAllCoin() {
        return coinRepository.findAll();
    }

    public Coin getCoinyId(Integer id) {
        return coinRepository.findById(id).orElse(null);
    }

    public void addCoin(Coin coin) {
        coinRepository.save(coin);
    }

    public void updateCoin(Integer id, Coin coin) {
        coinRepository.save(coin);

    }

    public void deleteCoin(Integer id) {
        coinRepository.deleteById(id);
    }
}
