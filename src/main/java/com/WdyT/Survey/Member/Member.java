package com.WdyT.Survey.Member;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER_TB")
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MEMBER_PK")
    private long id;

    @Column(name = "MEMBER_NM")
    private String nickname;

    @Column(name = "MEMBER_PW")
    private String password;

    @Column(name = "MEMBER_ROLE")
    private String role;


}
