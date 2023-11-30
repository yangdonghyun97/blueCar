package com.bluecar.bluecar.service;

import com.bluecar.bluecar.repository.MemberRepository;
import com.bluecar.bluecar.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public MemberDTO findId(MemberDTO memberDTO) {
        return memberRepository.findId(memberDTO);
    }


    public int save(MemberDTO member) {
        return memberRepository.save(member);
    }

    public int update(MemberDTO memberDTO) {
        return memberRepository.update(memberDTO);
    }

    public int delte(MemberDTO memberDTO) {
      return   memberRepository.delete(memberDTO);
    }

    public MemberDTO findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
