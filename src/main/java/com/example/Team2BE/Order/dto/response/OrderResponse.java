package com.example.Team2BE.Order.dto.response;

import com.example.Team2BE.Order.domain.Order;

import java.util.List;

public class OrderResponse {
    List<Order> orderList;

    public OrderResponse(List<Order> orderList) {
        this.orderList = orderList;
    }
}
