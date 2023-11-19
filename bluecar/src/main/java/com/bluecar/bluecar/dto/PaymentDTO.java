package com.bluecar.bluecar.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long id;
    private String amount;
    private String orderId;
    private long member_id;
    private String orderName;
    private String customerName;
    private String startRentalDate;
    private String endRentalDate;

}
