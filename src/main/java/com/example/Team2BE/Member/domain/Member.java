package com.example.Team2BE.Member.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 생성 전략
    private Long id;

    @Column
    private String memberId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String memberRank;

    public Member(String memberId, String password, String name) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.memberRank = "bronze";
    }
}
