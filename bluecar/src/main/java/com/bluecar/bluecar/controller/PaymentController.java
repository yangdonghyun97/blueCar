package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.dto.PaymentDTO;
import com.bluecar.bluecar.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/list")
    public @ResponseBody List<PaymentDTO> list(PaymentDTO paymentDTO){
        System.out.println("paymentDTO = " + paymentDTO);
        List<PaymentDTO> paymentDTOS = paymentService.findAll(paymentDTO.getId());
        System.out.println("paymentDTOS = " + paymentDTOS);
        return paymentDTOS;

    }

    @PostMapping("/save")
    public @ResponseBody String save(@RequestBody PaymentDTO paymentDTO){
        System.out.println("paymentDTO = " + paymentDTO);
        int result = paymentService.save(paymentDTO);
        return String.valueOf(result);

    }

    @PostMapping("/delete")
    public @ResponseBody String delete(PaymentDTO paymentDTO){
    int result  = paymentService.delete(paymentDTO);
    return String.valueOf(result);
    }
}
