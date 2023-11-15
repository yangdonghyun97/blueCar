package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardRepository {
   public int save(BoardDTO boardDTO);

   List<BoardDTO> findAll();

   BoardDTO findById(Long id);

    void updateHits(Long id);

    int update(BoardDTO boardDTO);

    int delete(BoardDTO boardDTO);
}
