package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.PaymentDTO;
import com.bluecar.bluecar.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    public int save(PaymentDTO paymentDTO) {
        return paymentRepository.save(paymentDTO);
    }

    public List<PaymentDTO> findAll(Long id) {
        return paymentRepository.findAll(id);
    }

    public PaymentDTO findById(Long id){
        return paymentRepository.findById(id);
    }

    public int delete(PaymentDTO paymentDTO) {
        return paymentRepository.delete(paymentDTO);
    }

    public List<PaymentDTO> findByname(PaymentDTO paymentDTO) {
        return  paymentRepository.findByName(paymentDTO);
    }
}
