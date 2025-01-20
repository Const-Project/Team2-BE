package com.example.Team2BE.Admin.dto.response;

import lombok.Getter;

@Getter
public class AdminResponse {

    private String memberId;
    private String menu;
    private Long cost;

    public AdminResponse(String memberId, String menu, Long cost) {
        this.memberId = memberId;
        this.menu = menu;
        this.cost = cost;
    }
}
