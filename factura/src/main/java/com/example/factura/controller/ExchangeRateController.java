package com.example.factura.controller;

import com.example.factura.model.Coin;
import com.example.factura.model.ExchangeRate;
import com.example.factura.services.CoinService;
import com.example.factura.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchangeRate")
public class ExchangeRateController {
    @Autowired
    private CoinService coinService;
    @Autowired
    private ExchangeRateService exchangeRateService;
    @GetMapping
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRate() {
        return ResponseEntity.ok(exchangeRateService.getAllExchangeRate());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeRate> getExchangeRateById(@PathVariable Integer id) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateById(id);
        if (exchangeRate != null) {
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<ExchangeRate> createInvoice(@RequestBody ExchangeRate exchangeRate) {

        Coin coinDestination = coinService.getCoinyId(exchangeRate.getIdODestinationCoin());
        Coin coinOrigin = coinService.getCoinyId(exchangeRate.getIdOriginCoin());
        if (coinOrigin!= null && coinDestination != null){
            exchangeRateService.addExchangeRate(exchangeRate);
            return new ResponseEntity<>(exchangeRate, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ExchangeRate> deleteExchangeRateById(@PathVariable Integer id) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateById(id);
        if (exchangeRate!= null) {
            exchangeRateService.deleteExchangeRate(id);
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable Integer id, @RequestBody ExchangeRate exchangeRate) {
        if (exchangeRateService.getExchangeRateById(id) != null) {
            Coin coinDestination = coinService.getCoinyId(exchangeRate.getIdODestinationCoin());
            Coin coinOrigin = coinService.getCoinyId(exchangeRate.getIdOriginCoin());
            if (coinOrigin!= null && coinDestination != null){
                exchangeRateService.updateExchangeRate(id, exchangeRate);
                return new ResponseEntity<>(exchangeRate, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
