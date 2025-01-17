package com.example.Team2BE.Member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    @Column
    private String memberId;

    @Column
    private String password;

    @Column
    private String name;

    public Member(String memberId, String password, String name) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
    }
}
