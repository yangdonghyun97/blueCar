package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.CarDTO;
import com.bluecar.bluecar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    @GetMapping("/carlist")
    public String carList(Model model) {
       List<CarDTO> carDTOS  = carService.findAll();
        model.addAttribute("carlist",carDTOS);
        System.out.println("carDTOS = " + carDTOS);
        return "carList";
    }

//    @GetMapping("/carDetail")
//    public String carDetail(){
//        return "carDetail";
//    }

    @GetMapping("/carDetailForm")
    public String carDetailForm(CarDTO carDTO, Model model) {
        System.out.println("carDTO = " + carDTO);
        model.addAttribute("car", carDTO);
        return "carDetail";

    }
}
