package com.bluecar.bluecar.service;

import com.bluecar.bluecar.controller.CarController;
import com.bluecar.bluecar.dto.CarDTO;
import com.bluecar.bluecar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<CarDTO> findAll() {
       return carRepository.findAll();
    }


}
