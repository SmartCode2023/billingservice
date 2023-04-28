package com.example.factura.controller;

import com.example.factura.model.Coin;
import com.example.factura.model.PayMethod;
import com.example.factura.services.CoinService;
import com.example.factura.services.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/billing/payMethod")
public class PayMethodController {
    @Autowired
    private PayMethodService payMethodService;

    @GetMapping
    public ResponseEntity<List<PayMethod>> getAllPayMethod() {
        return ResponseEntity.ok(payMethodService.getAllPayMethod());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayMethod> updatePayMethod(@PathVariable Integer id, @RequestBody PayMethod payMethod) {
        if (payMethodService.getPayMethodById(id) != null) {
            payMethodService.updatePayMethod(id, payMethod);
            return new ResponseEntity<>(payMethod, HttpStatus.OK);
        }
        return new ResponseEntity<>(payMethod, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PayMethod> getPayMethodById(@PathVariable Integer id) {
        PayMethod payMethod = payMethodService.getPayMethodById(id);
        if (payMethod != null) {
            return new ResponseEntity<>(payMethod, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PayMethod> deletePayMethodById(@PathVariable Integer id) {
        PayMethod payMethod = payMethodService.getPayMethodById(id);
        if (payMethod!= null) {
            payMethodService.deletePayMethod(id);
            return new ResponseEntity<>(payMethod, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<PayMethod> createPayMethod(@RequestBody PayMethod payMethod) {
        payMethodService.addPayMethod(payMethod);
        return new ResponseEntity<>(payMethod, HttpStatus.CREATED);
    }
}
