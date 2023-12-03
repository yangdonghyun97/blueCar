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
        System.out.println("carDTOS = " + carDTOS);
        model.addAttribute("carlist",carDTOS);
        return "car/carList";
    }

//    @GetMapping("/carDetail")
//    public String carDetail(){
//        return "carDetail";
//    }

    @GetMapping("/carDetail")
    public String carDetailForm(CarDTO carDTO, Model model) {
        System.out.println("carDTO = " + carDTO);
        // 받은 데이터를 모델에 추가
        model.addAttribute("car", carDTO);

        // 최종적으로 이동할 페이지 리턴
        return "car/carDetailPage";
    }

    @GetMapping("/carDetailPage")
    public String carDetailPage() {

        return "car/carDetailPage";
    }
}




