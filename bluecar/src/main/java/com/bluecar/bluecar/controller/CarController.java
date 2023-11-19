package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.CarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {


    @GetMapping("/carlist")
    public String carList(){
        return "carList";
    }

//    @GetMapping("/carDetail")
//    public String carDetail(){
//        return "carDetail";
//    }

    @GetMapping("/carDetailForm")
    public String carDetailForm(CarDTO carDTO, Model model){
        System.out.println("carDTO = " + carDTO);
        model.addAttribute("car", carDTO);
        return "carDetail";

    }
}
