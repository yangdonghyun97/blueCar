package com.bluecar.bluecar.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CarDTO {

    private Long id;
    private String area;
    private String model;
    private String yearRange;
    private int priceHors;
    private String priceDay;
    private String src;
    private Long quantity;
    private MultipartFile carFile; // 파일을 담는 용도
    private String originalFileName; // 원본 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름
    private int fileAttached; // 파일 첨부 여부(첨부 1, 미첨부 0)
}
