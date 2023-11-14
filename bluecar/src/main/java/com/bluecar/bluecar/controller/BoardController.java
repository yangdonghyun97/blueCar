package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/")
    public String findAll(Model model){
      List<BoardDTO> boardDTOList = boardService.findAll();
      model.addAttribute("boards", boardDTOList);
      return "boardlist";
    }

    @GetMapping("/saveform")
    public String saveForm(){

        return "boardQnASave";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO){
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0){
            return "redirect:/board/";
        }else{
            return "boardQnASave";
        }

    }

    @GetMapping("/boardDetail")
    public String findById(@RequestParam("id") Long id, Model model){
        boardService.updateHits(id);
       BoardDTO boardDTO = boardService.findById(id);
       model.addAttribute("board",boardDTO);
        return "boardDetail";
    }

    @PostMapping("/update")
    public String boardUpdate(BoardDTO boardDTO){
       int result = boardService.update(boardDTO);
       if(result ==1){
           return "redirect: /board/";
       }

        return "error";
    }
}
