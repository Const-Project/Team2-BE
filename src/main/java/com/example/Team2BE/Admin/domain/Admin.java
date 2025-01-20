package com.example.Team2BE.Admin.domain;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Order.domain.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JoinColumn
    @ManyToOne
    Order order;

}
