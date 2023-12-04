package com.WdyT.Survey.Member;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberParam {

    private String email;
    private String nickname;
    private String password;
    private int age;
}
