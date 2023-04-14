package com.example.factura.services;

import com.example.factura.model.Invoice;
import com.example.factura.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;


    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Integer id, Invoice invoice) {
        invoiceRepository.save(invoice);

    }

    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
