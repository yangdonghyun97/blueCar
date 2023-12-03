package com.bluecar.bluecar.controller;

import com.bluecar.bluecar.dto.MemberDTO;
import com.bluecar.bluecar.service.MemberService;
import com.bluecar.bluecar.service.PaymentService;
import lombok.RequiredArgsConstructor;
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

        return "user/regform";
    }


    @GetMapping("/loginform")
    public String loginForm(){
        return "user/loginform";
    }

    @GetMapping("/mypage/{userId}")
    public String myPage(MemberDTO memberDTO, Model model){
       MemberDTO member= memberService.findId(memberDTO);
       model.addAttribute("user", member);
        return "user/mypage";
    }

    @GetMapping("/kakaoRegform")
    public String kakaoRegform(@RequestParam("email") String email,Model model
    ){
        model.addAttribute("email",email);
        return "user/kakaoRegform";
    }


    @PostMapping("/kakaoLogin")
    public @ResponseBody String kakaoLogin(@RequestParam("email") String email,
                                           @RequestParam("kakaoToken") String kakaoToken,
                                           HttpSession session) {
        // Validate the Kakao token (you may want to call Kakao API to validate)
        // Process Kakao login logic
        MemberDTO memberInfo = memberService.findByEmail(email);
        String result = "";

        if (memberInfo == null) {
            result = "0";
        } else {
            session.setAttribute("userId", memberInfo.getUserId());
            session.setAttribute("id", memberInfo.getId());
            session.setAttribute("kakaoToken", kakaoToken);
            result = "1";
        }

        return result;
    }


    @GetMapping("/naverLogin")
    public @ResponseBody String naverLogin(@RequestParam("email") String email,
                                           @RequestParam("naverToken") String naverToken,
                                           HttpSession session) {
        // Validate the Kakao token (you may want to call Kakao API to validate)
        // Process Kakao login logic
        MemberDTO memberInfo = memberService.findByEmail(email);
        String result = "";

        if (memberInfo == null) {
            result = "0";
        } else {
            session.setAttribute("userId", memberInfo.getUserId());
            session.setAttribute("id", memberInfo.getId());
            session.setAttribute("naverToken", naverToken);
            result = "1";
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
        session.removeAttribute("kakaoToken");
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
            return "user/regform";

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
           return "user/mypage";
       }

    }

    @GetMapping("/delete")
    public @ResponseBody String  memberDelete(MemberDTO memberDTO, HttpSession session){
        int result = memberService.delte(memberDTO);
        System.out.println("memberDTO = " + memberDTO);
        session.removeAttribute("userId");

      return String.valueOf(result);
    }

    @GetMapping("/adminDelete")
    public @ResponseBody String  adminDelete(MemberDTO memberDTO, HttpSession session){
        int result = memberService.delte(memberDTO);
        System.out.println("memberDTO = " + memberDTO);
        return String.valueOf(result);
    }
}
