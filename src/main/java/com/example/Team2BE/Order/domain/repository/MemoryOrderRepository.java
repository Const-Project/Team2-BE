package com.example.Team2BE.Order.domain.repository;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Order.domain.Order;
import com.example.Team2BE.Order.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository
public class MemoryOrderRepository implements OrderRepository {

    private static Map<Long, Order> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Order save(Order order)
    {
        order.setId(++sequence);
        store.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Order> findAllByMember(Member member)
    {
        return store.values().stream()
                .filter(order -> order.getMember().getMemberId().equals(member.getMemberId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long orderId)
    {
        Optional<Order> order = findById(orderId);
        if (order.isPresent()) {
            Order o = order.get();
            store.remove(o.getId());
            return true;
        } else return false;
    }

    @Override
    public List<Order> findAll()
    {
        return new ArrayList<>(store.values());
    }

}
