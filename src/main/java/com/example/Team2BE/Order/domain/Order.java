package com.example.Team2BE.Order.domain;

import com.example.Team2BE.Member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="orders")
public class Order {

    @Id
    private Long id;

    @Column
    private String menu;

    @Column
    private Long cost;

    @Column
    private Long quantity;

    @Column
    private Long isPacked;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

    public Order(String menu, Long cost, Long quantity, Long isPacked, Member member) {
        this.menu = menu;
        this.cost = cost;
        this.quantity = quantity;
        this.isPacked = isPacked;
        this.member = member;
    }
}
