package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.CarDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
@Repository
public interface CarRepository {

    List<CarDTO> findAll();
}
