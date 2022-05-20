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


    public MemberDTO login(MemberDTO memberDTO){
        MemberDTO memberDTO1 = memberRepository.login(memberDTO);
        return memberDTO1;
    }


    public MemberDTO detail(int id) {
        return memberRepository.detail(id);
    }


    public boolean delete(int id) {
        int deleteResult = memberRepository.delete(id);
        if (deleteResult > 0){
            return true;
        }else{
            return false;
        }
    }
}
