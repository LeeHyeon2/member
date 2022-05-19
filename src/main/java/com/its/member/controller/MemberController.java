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
                return "login-form";
            }else{
                return "index";
            }
    }

    @GetMapping("/login-form")
    public String loginForm(){
        return "login-form";
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
    public String login(@ModelAttribute MemberDTO memberDTO){
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult){
            return "main";
        }else {
            return "index";
        }
    }

}
