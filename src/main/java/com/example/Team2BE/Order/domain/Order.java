package com.example.Team2BE.Order.domain;

import com.example.Team2BE.Member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {

    @Id
    private Long orderId;

    @Column
    private String menu;

    @Column
    private Long cost;

    @Column
    private Long quantity;

    @Column
    private Long isPacked;

    @JoinColumn
    @ManyToOne
    Member member;

    public Order(String menu, Long cost, Long quantity, Long isPacked, Member member) {
        this.menu = menu;
        this.cost = cost;
        this.quantity = quantity;
        this.isPacked = isPacked;
        this.member = member;
    }
}
