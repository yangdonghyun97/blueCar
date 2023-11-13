package com.bluecar.bluecar.repository;

import com.bluecar.bluecar.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
     int save(MemberDTO member);

     MemberDTO findId(MemberDTO memberDTO);

    int update(MemberDTO memberDTO);

    int delete(MemberDTO memberDTO);
}
