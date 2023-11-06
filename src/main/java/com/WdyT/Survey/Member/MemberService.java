package com.WdyT.Survey.Member;

import java.util.List;

public interface MemberService {

    long joinMember(MemberParam memberParam);

    long deleteMember(long id);

    MemberParam getMemberByNM(String name);

    List<MemberParam> getMembersByRole(String role);

    long loginMember();

    long logoutMember();

}
