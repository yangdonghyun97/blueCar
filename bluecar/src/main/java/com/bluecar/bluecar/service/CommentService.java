package com.bluecar.bluecar.service;

import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

   private final CommentRepository commentRepository;

    public void save(CommentDTO commentDTO) {
        commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        System.out.println("boardId ser = " + boardId);
       return commentRepository.findAll(boardId);
    }
}
