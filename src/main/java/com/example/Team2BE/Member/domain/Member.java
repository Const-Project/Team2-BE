package com.example.Team2BE.Member.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Column
    private String rank;

    public Member(String memberId, String password, String name) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.rank = "bronze";
    }
}
