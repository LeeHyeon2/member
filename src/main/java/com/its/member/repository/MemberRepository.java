package com.its.member.repository;

import com.its.member.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save",memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }


    public MemberDTO login(MemberDTO memberDTO) {
        System.out.println(sql.selectOne("Member.login",memberDTO));
        return sql.selectOne("Member.login",memberDTO);
    }
}