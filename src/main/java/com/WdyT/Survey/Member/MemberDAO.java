package com.WdyT.Survey.Member;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberDAO extends JpaRepository<Member, Long> {

    Optional<Member> findById(long id);
    Optional<Member> findByNickname(String nm);
    List<Optional<Member>> findAllByRole(String role);


}
