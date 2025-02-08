package com.example.Team2BE.Order.domain.repository;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByMember(Member m);

}
