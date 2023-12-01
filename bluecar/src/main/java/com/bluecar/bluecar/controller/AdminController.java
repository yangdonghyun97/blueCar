package com.bluecar.bluecar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("adminIndex")
    public String adminIndex(){
        return "adminIndex";
    }

    @GetMapping("adminLogin")
    public String adminLogin(HttpSession session){
    session.setAttribute("admin", "true");
        return "loginform";
    }

    @GetMapping("adminPage")
    public String adminPage(){
        return "adminPage";
    }
}
