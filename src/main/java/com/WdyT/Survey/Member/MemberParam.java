package com.WdyT.Survey.Member;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberParam {

    long id;
    String nm;
    String pw;
    String role;
}
