package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PaymentRepository {

    public int save(PaymentDTO paymentDTO);

    public List<PaymentDTO> findAll(Long id);

    PaymentDTO findById(Long id);

    int delete(PaymentDTO paymentDTO);

    List<PaymentDTO> findByName(PaymentDTO paymentDTO);
}
