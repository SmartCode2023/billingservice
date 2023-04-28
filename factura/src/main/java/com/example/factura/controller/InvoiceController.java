package com.example.factura.controller;

import com.example.factura.model.Coin;
import com.example.factura.model.Invoice;
import com.example.factura.model.PayMethod;
import com.example.factura.services.CoinService;
import com.example.factura.services.InvoiceService;
import com.example.factura.services.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceServiceService;

    @Autowired
    private PayMethodService payMethodService;

    @Autowired
    private CoinService coinService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        return ResponseEntity.ok(invoiceServiceService.getAllInvoice());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) {
        Invoice invoice = invoiceServiceService.getInvoiceById(id);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        PayMethod payMethod = payMethodService.getPayMethodById(invoice.getIdPayMethod());
        Coin coin = coinService.getCoinyId(invoice.getIdCoin());
        if (payMethod!= null && coin != null){
            invoiceServiceService.addInvoice(invoice);
            return new ResponseEntity<>(invoice, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoiceById(@PathVariable Integer id) {
        Invoice invoice = invoiceServiceService.getInvoiceById(id);
        if (invoice!= null) {
            invoiceServiceService.deleteInvoice(id);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {
        if (invoiceServiceService.getInvoiceById(id) != null) {
            PayMethod payMethod = payMethodService.getPayMethodById(invoice.getIdPayMethod());
            Coin coin = coinService.getCoinyId(invoice.getIdCoin());
            if (payMethod!= null && coin != null){
                invoiceServiceService.updateInvoice(id, invoice);
                return new ResponseEntity<>(invoice, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
