package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberReopository {
     int save(MemberDTO member);

     MemberDTO findId(MemberDTO memberDTO);

    int update(MemberDTO memberDTO);
}
