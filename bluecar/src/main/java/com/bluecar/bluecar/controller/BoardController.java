package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.dto.PageDTO;
import com.bluecar.bluecar.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
      return "board/boardlist";
    }

    @GetMapping("/category/{category}")
    public @ResponseBody List<BoardDTO>  findByCategory(BoardDTO boardDTO, Model model){
        List<BoardDTO> boardDTOList = boardService.findByCategory(boardDTO);
        model.addAttribute("board", boardDTOList);
            return boardDTOList;
    }

    @GetMapping("/informationUse")
    public String informationUse(){
        return "informationUse";
    }

    @GetMapping("/boardQnAWriteForm")
    public String saveForm(){

        return "board/boardQnAWriteForm";
    }

    @PostMapping("/save")
    public @ResponseBody String save(BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        int saveResult = boardService.save(boardDTO);
      
        if (saveResult > 0){
            return "성공";
        }else{
            return "error";
        }

    }

    @GetMapping("/boardDetail")
    public String findById(@RequestParam("id") Long id, Model model){
        boardService.updateHits(id);
       BoardDTO boardDTO = boardService.findById(id);
       model.addAttribute("board",boardDTO);
        return "board/boardDetail";
    }

    @PostMapping("/update")
    public @ResponseBody  String boardUpdate(BoardDTO boardDTO){
       int result = boardService.update(boardDTO);
        System.out.println("result = " + result);
       if(result ==1){
           return "성공";
       }
        return "error";
    }

    @PostMapping("/delete")
    public @ResponseBody String boardDelete(BoardDTO boardDTO){
       int result = boardService.delete(boardDTO);
        if(result ==1){
            return "성공";
        }
        return "error";

    }

    // /board/paging?page=2
    @GetMapping("/paging")
    public  String paging(Model model,@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        System.out.println("page = " + page);
        // 해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        System.out.println("pagingList = " + pagingList);

        PageDTO pageDTO = boardService.pagingParma(page);
        model.addAttribute("pagingList", pagingList);
        model.addAttribute("paging", pageDTO);

        return "board/boardlist";
    }

}
