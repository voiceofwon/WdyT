package com.WdyT.Survey.Member;


import com.WdyT.Survey.Member.JWT.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    public MemberService memberService;

    @Autowired
    public MemberDAO memberDAO;

    @Autowired
    public JwtService jwtService;

    /*@Test
    @DisplayName("DB 연동 Test")
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
    }*/

    @Test
    @Rollback
    void checkAccessTokenTest(){
        //given
        MockHttpServletRequest servlet = new MockHttpServletRequest();

        servlet.addHeader("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBY2Nlc3NUb2tlbiIsImV4cCI6MTcwMTQyODI0MSwiZW1haWwiOiIyNjBlNGIyNy1kZDAxLTQyNjYtYThjMC0yNmRhNzgxMDVjODNAc29jaWFsVXNlci5jb20ifQ.BJ05CxeuI_zFg1sxCfEJcIf2k5_wwZngzSqCqzVlDaYbGnh7oCNYskuHDgsM_bDBCt4LBW929kiIp-4qJ1zhMA");

        //when
        Optional<String> acc = jwtService.extractAccessToken(servlet);



        //then
        Assertions.assertEquals(acc.get(),"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBY2Nlc3NUb2tlbiIsImV4cCI6MTcwMTQyODI0MSwiZW1haWwiOiIyNjBlNGIyNy1kZDAxLTQyNjYtYThjMC0yNmRhNzgxMDVjODNAc29jaWFsVXNlci5jb20ifQ.BJ05CxeuI_zFg1sxCfEJcIf2k5_wwZngzSqCqzVlDaYbGnh7oCNYskuHDgsM_bDBCt4LBW929kiIp-4qJ1zhMA");
        /*System.out.println(servlet.getHeader("Authorization"));*/
    }
}
