package com.example.Team2BE.Order.dto.request;

import lombok.Getter;

@Getter
public class OrderRequest {
    private String menu;

    private Long cost;

    private Long quantity;

    private Long isPacked;

    private String memberId;

}
