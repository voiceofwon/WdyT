package com.WdyT.Survey.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/auth/login")
    public String loginPage(){

        return "index.html";
    }

    @PostMapping("/auth/login")
    public String login(){
        return "not done";
    }

    @GetMapping("/auth/joinUs")
    public String joinPage(){

        return "회원가입 페이지";
    }

    @PostMapping("/auth/joinUs")
    public String join(@RequestBody MemberParam memberParam) throws Exception{
        memberService.joinMember(memberParam);
        return "회원가입 성공!";
    }
    /*@GetMapping("/auth/kakao")
    public String kakao(){
        return "카카오 인증";
    }
    */

    /*@GetMapping("/auth/google")
    public String google(){
        return "구글 인증";
    }
    */


}
