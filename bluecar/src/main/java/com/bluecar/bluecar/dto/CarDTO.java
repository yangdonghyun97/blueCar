package com.bluecar.bluecar.dto;


import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private String area;
    private String model;
    private String yearRange;
    private int priceHors;
    private int priceDay;
    private String src;
    private Long quantity;

}
