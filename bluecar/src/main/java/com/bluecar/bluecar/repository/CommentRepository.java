package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {

    public int save(CommentDTO commentDTO);

    public List<CommentDTO> findAll(Long boardId);

    int delete(CommentDTO commentDTO);
}
