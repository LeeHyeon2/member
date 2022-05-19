package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    public MemberRepository memberRepository;
    public boolean save(MemberDTO memberDTO) {
        int saveResult = memberRepository.save(memberDTO);
        if(saveResult>0){
            return true;
        }else {
            return false;
        }

    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        return  memberDTOList;
    }


    public boolean login(MemberDTO memberDTO){
        MemberDTO memberDTO1 = memberRepository.login(memberDTO);
        if(memberDTO1==null){
            return false;
        }else{
            return true;
        }
    }
}
