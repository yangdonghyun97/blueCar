package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {


    private final MemberService memberService;

    ////////Veiw
    @GetMapping("/regform")
    public String regForm() {

        return "regform";
    }

    @GetMapping("/loginform")
    public String loginForm(){
        return "loginform";
    }

    @GetMapping("/mypage/{userId}")
    public String myPage(MemberDTO memberDTO, Model model){
       MemberDTO member= memberService.findId(memberDTO);
       model.addAttribute("user", member);
        return "mypage";
    }





    @PostMapping("/login")
    public @ResponseBody String login(MemberDTO memberdto , HttpSession session) {
        MemberDTO memberDTO = memberService.findId(memberdto);

        if (memberDTO == null || memberDTO.getPw() == null) {
            return "계정 정보를 다시 확인해주세요";
        }

        String inputPw = memberdto.getPw();
        String storedPw = memberDTO.getPw();


        if (inputPw.equals(storedPw)) {
            session.setAttribute("userId", memberDTO.getUserId());
            session.setAttribute("id", memberDTO.getId());
            return "성공";
        }

        return "계정 정보를 다시 확인해주세요";
    }
    @GetMapping("/logout")
    public String  logout(HttpSession session){
        session.removeAttribute("userId");
        return "redirect:/";
    }


    /////////등록
    @PostMapping("/save")
    public String memberSave(MemberDTO member, Model model) {
        int result = memberService.save(member);
        System.out.println("result = " + result);
        if (result == 1) {
            model.addAttribute("memberId", member.getId());
            return "redirect:/";
        } else {
            return "regform";

        }
    }

    //////업데이트
    @PostMapping("/update")
    public  String memberUpdate(MemberDTO memberDTO){
       int result = memberService.update(memberDTO);
       if(result == 1){
           return "redirect:/";
       }else {
           return "mypage";
       }

    }

    @GetMapping("/delete")
    public @ResponseBody String  memberDelete(MemberDTO memberDTO, HttpSession session){
        int result = memberService.delte(memberDTO);
        session.removeAttribute("userId");

      return String.valueOf(result);
    }
}
