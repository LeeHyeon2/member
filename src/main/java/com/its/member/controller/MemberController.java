package com.its.member.controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update-form")
    public String updateForm(HttpSession session,Model model) {
        // 로그인 한 상태기 때문에 세션에 id, memberId가 들어있고
        // 여기서 세션에 있는 id를 가져온다.
        int updateId = (int) session.getAttribute("loginId");
        System.out.println("updateId = " + updateId);
        // DB에서 해당 회원의 정보를 가져와서 그 정보를 가지고 update.jsp로 이동
        MemberDTO memberDTO = memberService.detail(updateId);
        model.addAttribute("updateMember",memberDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        boolean updateResult = memberService.update(memberDTO);
        System.out.println("memberDTO = " + memberDTO);
        if(updateResult){
            // 해당 회원의 상세정보
            return "redirect:/detail?id=" + memberDTO.getId();
        }else{
            return "update-fail";
        }
    }

    @PostMapping("duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId){
        System.out.println("memberId = " + memberId);
        // memberId를 DB에서 중복값이 있는지 없는지 체크하고
        // 없으면 ok, 있으면 no 라는 String 값을 리턴받으세용.
        String checkResult = memberService.duplicateCheck(memberId);

        return checkResult;
    }

    @GetMapping("/response-test")
    public @ResponseBody String responseTest(){
        return "main";
    }

    @GetMapping("/response-test2")
    public @ResponseBody List<MemberDTO> responseTest2() {
        return memberService.findAll();
    }
    @PostMapping("/ajax1")
    public @ResponseBody MemberDTO ajax1(@RequestParam("id") int id){
        MemberDTO memberDTO = memberService.detail(id);
        if(memberDTO==null){
            return null;
        }else{
            return memberDTO;
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

}
