package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.BoardDTO;
import com.bluecar.bluecar.dto.CarDTO;
import com.bluecar.bluecar.dto.CommentDTO;
import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.service.AdminService;
import com.bluecar.bluecar.service.BoardService;
import com.bluecar.bluecar.service.CarService;
import com.bluecar.bluecar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;
    private final BoardService boardService;
    private final CarService carService;
    @GetMapping("adminIndex")
    public String adminIndex(){
        return "adminIndex";
    }

    @GetMapping("adminLogin")
    public String adminLogin(HttpSession session){
    session.setAttribute("admin", "true");
        return "user/loginform";
    }


    @GetMapping("charts")
    public String charts(){
        return "admin/charts";
    }
    @GetMapping("userList")
    public String userList(Model model){
        List<MemberDTO> memberInfo = adminService.findAll();
        System.out.println("memberInfo = " + memberInfo);
        model.addAttribute("users", memberInfo);
        return "admin/user/userList";
    }
    @GetMapping("boardList")
    public String boardList(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        System.out.println("boardList = " + boardList);
        model.addAttribute("boards", boardList);
        return "admin/board/boardList";
    }

    @GetMapping("carList")
    public String carList(Model model){
        List<CarDTO> carList = carService.findAll();
        model.addAttribute("cars", carList);
        return "admin/car/carList";
    }


    @GetMapping("enrollment")
    public String enrollment(CarDTO carDTO) {


        return "admin/car/enrollment";
    }

    @PostMapping("carReg")
    public String carReg(CarDTO carDTO)throws IOException {
        adminService.carSave(carDTO);
        return "redirect: admin/car/enrollment";
    }


    @GetMapping("answer/{id}")
    public String answer(BoardDTO boardDTO ,Model model){
      BoardDTO boardInfo = boardService.findById(boardDTO.getId());
      model.addAttribute("board",boardInfo);
      return "admin/board/answer";
    }

    @GetMapping("/user/updateForm/{id}")
    public String userUpdate(MemberDTO memberDTO,Model model){
   MemberDTO memberInfo= adminService.findId(memberDTO);

      model.addAttribute("user",memberInfo);
        return "admin/user/update";
    }

    @PostMapping("userUpdate")
    public String userUpdate(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        adminService.userUpdate(memberDTO);
       return "redirect:/admin/user/update";

    }
    @PostMapping("/answerUpdate")
    public String commentSave(CommentDTO commentDTO){
        adminService.adminCommentSave(commentDTO);
        String state="답변완료";
        adminService.stateUdpate(state,commentDTO.getBoardId());

        return "redirect:/admin/boardList";
    }


    @GetMapping("adminPage")
    public String adminPage(Model model) {
        List<MemberDTO> memberInfo = adminService.findAll();
        System.out.println("memberInfo = " + memberInfo);
        model.addAttribute("users", memberInfo);
        return "admin/adminPage";
    }


}
