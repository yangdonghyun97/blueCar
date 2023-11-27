package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.repository.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class EmailController {
private final EmailService emailService;


    @PostMapping("/emailConfirm")
    public @ResponseBody String emailConfirm(@RequestParam String email) throws Exception {

        String certificationNumber = emailService.sendSimpleMessage(email);

        return certificationNumber;
    }
}
