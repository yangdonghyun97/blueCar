package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.CarDTO;
import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminRepository {
    List<MemberDTO> findAll();

    MemberDTO findId(MemberDTO memberDTO);

    void userUpdate(MemberDTO memberDTO);

    void commentSave(CommentDTO commentDTO);

    void stateUpdate(@Param("state") String state, @Param("id") Long id);


    void adminCommentSave(CommentDTO commentDTO);

    void carSave(CarDTO carDTO, @Param("storedFileName") String storedFileName);
}
