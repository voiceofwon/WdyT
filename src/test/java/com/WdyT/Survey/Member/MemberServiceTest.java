package com.WdyT.Survey.Member;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    public MemberService memberService;

    @Autowired
    public MemberDAO memberDAO;

    @Test
    @Rollback
    @Transactional
    void joinMemberTest(){
        //given
        MemberParam memberParam = MemberParam.builder()
                .nm("감자천국")
                .pw("1102")
                .role("USER")
                .build();

        //when
        memberService.joinMember(memberParam);

        //then
        Assertions.assertEquals("감자천국",memberDAO.findByNickname("감자천국").get().getNickname());
    }
}
