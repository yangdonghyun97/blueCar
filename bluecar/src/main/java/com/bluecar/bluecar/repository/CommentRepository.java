package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {
   void save(CommentDTO commentDTO);

    List<CommentDTO> findAll(Long boardId);
}
