package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.dto.PaymentDTO;
import com.bluecar.bluecar.service.MemberService;
import com.bluecar.bluecar.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {


    private final MemberService memberService;
    private final PaymentService paymentService;
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

    @GetMapping("/kakaoRegform")
    public String kakaoRegform(@RequestParam("email") String email,Model model
    ){
        model.addAttribute("email",email);
        return "kakaoRegform";
    }


    @PostMapping("/emailCheck")
    public @ResponseBody String emailCheck(MemberDTO memberDTO, HttpSession session){
       MemberDTO memberDTO1 = memberService.findByEmail(memberDTO);
        System.out.println("memberDTO1 = " + memberDTO1);
       String result = "";
       if (memberDTO1 == null){
           result = "0";
       }else {
           session.setAttribute("userId", memberDTO1.getUserId());
           session.setAttribute("id", memberDTO1.getId());
           result ="1";
       }
        return result;
    }



    @PostMapping("/login")
    public @ResponseBody String login(MemberDTO memberdto , HttpSession session) {
        System.out.println("memberdto = " + memberdto);
        MemberDTO memberDTO = memberService.findId(memberdto);

        if (memberDTO == null || memberDTO.getPw() == null ) {
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

    @PostMapping("/duplicateCheck")
    public @ResponseBody String idCheck(MemberDTO memberDTO){
       MemberDTO userId = memberService.findId(memberDTO);
        System.out.println("userId = " + userId);

        // 0 이면 사용가능
        // 1 이면 불가능
       if(userId == null){
           return "0";
       }

        if(!userId.getUserId().isEmpty()){
            return "1";
        }else {
            // 아이디 사용가능
            return "0";
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
        System.out.println("memberDTO = " + memberDTO);
        session.removeAttribute("userId");

      return String.valueOf(result);
    }
}
