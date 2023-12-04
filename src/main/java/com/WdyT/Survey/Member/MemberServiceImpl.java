package com.WdyT.Survey.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    private final PasswordEncoder passwordEncoder;

    @Override
    public long joinMember(MemberParam memberParam) throws Exception{

        if(memberDAO.findByNickname(memberParam.getNickname()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if(memberDAO.findByEmail(memberParam.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        Member member = Member.builder()
                .email(memberParam.getEmail())
                .password(memberParam.getPassword())
                .nickname(memberParam.getNickname())
                .age(memberParam.getAge())
                .role(Role.USER)
                .build();

        member.passwordEncode(passwordEncoder);

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
