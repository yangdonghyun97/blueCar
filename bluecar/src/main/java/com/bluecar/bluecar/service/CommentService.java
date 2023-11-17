package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public int save(CommentDTO commentDTO) {
      return  commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }
}

