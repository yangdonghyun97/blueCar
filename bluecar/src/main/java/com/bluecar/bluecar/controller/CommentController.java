package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/list")
    public @ResponseBody List<CommentDTO> list(CommentDTO commentDTO){
        List<CommentDTO> commentList = commentService.findAll(commentDTO.getBoardId());
        System.out.println("commentList = " + commentList);
        return commentList;

    }

    @PostMapping("/save")
    public @ResponseBody String save(CommentDTO commentDTO){
       int result = commentService.save(commentDTO);
        return String.valueOf(result);

    }



}
