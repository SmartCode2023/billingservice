package com.example.factura.services;


import com.example.factura.model.PayMethod;
import com.example.factura.repository.PayMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayMethodService {
    @Autowired
    private PayMethodRepository payMethodRepository;


    public List<PayMethod> getAllPayMethod() {
        return payMethodRepository.findAll();
    }

    public PayMethod getPayMethodById(Integer id) {
        return payMethodRepository.findById(id).orElse(null);
    }

    public void addPayMethod(PayMethod payMethod) {
        payMethodRepository.save(payMethod);
    }

    public void updatePayMethod(Integer id, PayMethod payMethod) {
        payMethodRepository.save(payMethod);

    }

    public void deletePayMethod(Integer id) {
        payMethodRepository.deleteById(id);
    }
}
