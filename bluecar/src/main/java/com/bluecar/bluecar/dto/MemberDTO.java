package com.bluecar.bluecar.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class MemberDTO {

    private int fid;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String yeardate;


}
