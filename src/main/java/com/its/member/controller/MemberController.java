package com.its.member.controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    public MemberService memberService;

    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        boolean saveResult = memberService.save(memberDTO);
            if(saveResult){
                System.out.println("저장성공");
                return "login";
            }else{
                return "index";
            }
    }

    @GetMapping("/login-form")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "list";

    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);
        // 세션(session)
        if(loginResult != null){
            model.addAttribute("loginResult",loginResult);
            session.setAttribute("loginMemberId",loginResult.getMemberId());
            session.setAttribute("loginId",loginResult.getId());
            return "main";
        }else {
            return "index";
        }
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id , Model model){
       MemberDTO memberDTO = memberService.detail(id);
        model.addAttribute("member",memberDTO);
        return "detail";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id , Model model){
        boolean deleteResult = memberService.delete(id);
        /*List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);*/
        if(deleteResult){
            // redirect : 컨트롤러의 메서드에서 다른 메서드의 주소를 호출
            // redirect를 이용하여 findAll 주소 요청
            return "redirect:/findAll"; // list값 출력
        }
        else {
            return "delete-fail";
        }
    }



}
