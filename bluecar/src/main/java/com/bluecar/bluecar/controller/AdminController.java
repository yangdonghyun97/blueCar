package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.*;
import com.bluecar.bluecar.service.*;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final BoardService boardService;
    private final CarService carService;
    private final CommentService commentService;
    @GetMapping("/adminIndex")
    public String adminIndex(){
        return "/admin/adminIndex";
    }

    @GetMapping("/adminReg")
    public String adminLogin(HttpSession session){
    session.setAttribute("admin", "true");
        return "/user/regform";
    }



    @GetMapping("/userList")
    public String userList(Model model){
        List<MemberDTO> memberInfo = adminService.findAll();
        model.addAttribute("users", memberInfo);
        return "/admin/user/userList";
    }
    @GetMapping("/boardList")
    public String boardList(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boards", boardList);
        return "/admin/board/boardList";
    }

    @GetMapping("/carList")
    public String carList(Model model){
        List<CarDTO> carList = carService.findAll();
        model.addAttribute("cars", carList);
        return "/admin/car/carList";
    }


    @GetMapping("/enrollment")
    public String enrollment(CarDTO carDTO) {


        return "/admin/car/enrollment";
    }

    @PostMapping("/carReg")
    public String carReg(CarDTO carDTO)throws IOException {
        adminService.carSave(carDTO);
        return "redirect:carList";
    }

    @GetMapping("/carDelete/{id}")
    public String carDelete(@PathVariable("id") String id){
        adminService.carDelete(id);
        return "redirect:/admin/carList";
    }


    @GetMapping("/answer/{id}")
    public String answer(BoardDTO boardDTO ,Model model){
      BoardDTO boardInfo = boardService.findById(boardDTO.getId());

      List<CommentDTO> commentInfo = commentService.findAll(boardDTO.getId());
      model.addAttribute("comments", commentInfo);
      model.addAttribute("board",boardInfo);
      return "/admin/board/answer";
    }

    @GetMapping("/user/updateForm/{id}")
    public String userUpdate(MemberDTO memberDTO,Model model){
   MemberDTO memberInfo= adminService.findId(memberDTO);

      model.addAttribute("user",memberInfo);
        return "/admin/user/update";
    }

    @PostMapping("userUpdate")
    public String userUpdate(MemberDTO memberDTO){
        adminService.userUpdate(memberDTO);
       return "redirect:/admin/userList";

    }
    @PostMapping("/answerUpdate")
    public String commentSave(CommentDTO commentDTO){
        adminService.adminCommentSave(commentDTO);
        String state="답변완료";
        adminService.stateUdpate(state,commentDTO.getBoardId());

        return "redirect:/admin/boardList";
    }


    @GetMapping("/adminPage")
    public String adminPage(Model model) {
        List<MemberDTO> memberInfo = adminService.findAll();
        model.addAttribute("users", memberInfo);
        return "/admin/adminPage";
    }



    @GetMapping("/paymentList")
    public String paymentList(Model model){
       List<PaymentDTO> paymentDTOS= adminService.paymentList();
       model.addAttribute("payments",paymentDTOS);
       return "admin/payment/paymentList";
    }

    @GetMapping("/paymentDelete/{id}")
public String paymentDelete(@PathVariable("id") String id){
adminService.paymentDelete(id);
        return "redirect:/admin/paymentList";
    }
}
