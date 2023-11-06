package com.WdyT.Survey.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberDAO memberDAO;

    @Override
    public long joinMember(MemberParam memberParam) {
        Member member= Member.builder()
                .nickname(memberParam.getNm())
                .password(memberParam.getPw())
                .role(memberParam.getRole())
                .build();

        return memberDAO.save(member).getId();
    }

    @Override
    public long deleteMember(long id) {
        return 0;
    }

    @Override
    public long logoutMember() {
        return 0;
    }

    @Override
    public MemberParam getMemberByNM(String name) {
        return null;
    }

    @Override
    public List<MemberParam> getMembersByRole(String role) {
        return null;
    }

    @Override
    public long loginMember() {
        return 0;
    }
}
