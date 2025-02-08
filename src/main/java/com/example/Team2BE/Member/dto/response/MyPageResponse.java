package com.example.Team2BE.Member.dto.response;

import com.example.Team2BE.Member.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Getter
public class MyPageResponse {
    private final String name;
    private final String rank;
    private List<String> orderList;
    private Long bill;
    public static MyPageResponse from(final Member member) {
        return new MyPageResponse(member.getName(),member.getMemberRank());
    }

    public MyPageResponse(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }
}
