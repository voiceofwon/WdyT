package com.WdyT.Survey.Member;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER_TB")
public class Member{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MEMBER_PK")
    private long id;

    @Column(name = "MEMBER_Email")
    private String email;

    @Column(name = "MEMBER_NM")
    private String nickname;

    @Column(name = "MEMBER_PW")
    private String password;

    @Column(name = "MEMBER_AGE")
    private int age;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private String imageUrl;

    private String refreshToken;


    public void authorizeUser(){
        this.role = Role.USER;
    }

    public void authorizeADMIN(){
        this.role = Role.ADMIN;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String updateRefreshToken){
        this.refreshToken = updateRefreshToken;
    }
}
