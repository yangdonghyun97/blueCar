package com.bluecar.bluecar.dto;


import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private String area;
    private String model;
    private String yearRange;
    private String  price;
    private String src;
    private String startRentalDate;
    private String carCreatedTime;
    private String endRentalDate;
}
