package com.example.factura.controller;


import com.example.factura.model.Coin;
import com.example.factura.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping
    public ResponseEntity<List<Coin>> getAllCoin() {
        return ResponseEntity.ok(coinService.getAllCoin());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coin> updateCoin(@PathVariable Integer id, @RequestBody Coin coin) {
        if (coinService.getCoinyId(id) != null) {
            coinService.updateCoin(id, coin);
            return new ResponseEntity<>(coin, HttpStatus.OK);
        }
        return new ResponseEntity<>(coin, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinById(@PathVariable Integer id) {
        Coin coin = coinService.getCoinyId(id);
        if (coin != null) {
            return new ResponseEntity<>(coin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coin> deleteCoinById(@PathVariable Integer id) {
        Coin coin = coinService.getCoinyId(id);
        if (coin!= null) {
            coinService.deleteCoin(id);
            return new ResponseEntity<>(coin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Coin> createCoin(@RequestBody Coin coin) {
        coinService.addCoin(coin);
        return new ResponseEntity<>(coin, HttpStatus.CREATED);
    }
}
