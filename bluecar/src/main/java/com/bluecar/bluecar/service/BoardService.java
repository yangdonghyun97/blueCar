package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public int update(BoardDTO boardDTO) {
        return boardRepository.update(boardDTO);
    }

    public int delete(BoardDTO boardDTO) {
       return boardRepository.delete(boardDTO);
    }
}
