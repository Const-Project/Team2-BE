package com.example.Team2BE.Order.domain.repository;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAllByMember(Member member);
    boolean deleteById(Long orderId);
    List<Order> findAll();
}
