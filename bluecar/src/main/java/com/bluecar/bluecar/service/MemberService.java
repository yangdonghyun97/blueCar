package com.bluecar.bluecar.service;

import com.bluecar.bluecar.repository.MemberReopository;
import com.bluecar.bluecar.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberReopository memberReopository;

    public MemberDTO findId(MemberDTO memberDTO) {
        return memberReopository.findId(memberDTO);
    }


    public int save(MemberDTO member) {
        return memberReopository.save(member);
    }

    public int update(MemberDTO memberDTO) {
        return memberReopository.update(memberDTO);
    }
}
