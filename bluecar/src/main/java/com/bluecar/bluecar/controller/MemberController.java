package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    ////////Veiw
    @GetMapping("/regform")
    public String regForm() {

        return "regform";
    }

    @GetMapping("/loginform")
    public String loginForm(){
        return "loginform";
    }

    @GetMapping("/mypage/{id}")
    public String myPage(MemberDTO memberDTO, Model model){
       MemberDTO member= memberService.findId(memberDTO);
       model.addAttribute("user", member);
        return "mypage";
    }





    @PostMapping("/login")
    public @ResponseBody String login(MemberDTO memberdto , HttpSession session) {
        MemberDTO memberDTO = memberService.findId(memberdto);

        if(memberDTO ==null){
            return "계정 정보를 다시 확인해주세요";
        }else {
            session.setAttribute("userId", memberDTO.getId());
            return "성공";
        }

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
}
