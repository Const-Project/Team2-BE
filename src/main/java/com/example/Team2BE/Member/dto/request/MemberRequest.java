package com.example.Team2BE.Member.dto.request;


import lombok.Getter;

@Getter
public class MemberRequest {

    private String memberId;

    private String password;

    private String name;

    private String newPassword;
}
