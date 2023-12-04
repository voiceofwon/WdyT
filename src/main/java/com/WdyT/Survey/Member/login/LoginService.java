package com.WdyT.Survey.Member.login;

import com.WdyT.Survey.Member.Member;
import com.WdyT.Survey.Member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberDAO memberDAO;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Member member = memberDAO.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not exist"));

       return User.builder()
               .username(member.getEmail())
               .password(member.getPassword())
               .roles(member.getRole().name())
               .build();
    }
}
