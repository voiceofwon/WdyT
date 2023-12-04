package com.WdyT.Survey.Member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberDAO extends JpaRepository<Member, Long> {

    Optional<Member> findById(long id);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNickname(String nm);
    Optional<Member> findByRefreshToken(String refreshToken);
    List<Optional<Member>> findAllByRole(String role);

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);


}
