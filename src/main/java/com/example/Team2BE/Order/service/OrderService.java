package com.example.Team2BE.Order.service;


import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.domain.repository.MemberRepository;
import com.example.Team2BE.Order.domain.Order;
import com.example.Team2BE.Order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void createOrder(String menu, Long cost, Long quantity, Long isPacked, String memberId)
    {
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        if(member.isPresent()) {
            Member m = member.get();
            Order order = new Order(menu, cost, quantity, isPacked, m);
            orderRepository.save(order);
        }
    }

    @Transactional
    public void deleteOrder(String menu, Long quantity, String memberId)
    {
        Optional<Member> member = memberRepository.findByMemberId(memberId);

        if(member.isPresent())
        {
            Member m = member.get();
            List<Order> findList = orderRepository.findAllByMember(m);
            for(Order order : findList)
            {
                if(menu.equals(order.getMenu()) && order.getQuantity().equals(quantity))
                {
                    orderRepository.deleteById(order.getId());
                }
            }
        }
    }

    @Transactional
    public List<Order> getOrderList(String memberId)
    {
        Optional<Member> member = memberRepository.findByMemberId(memberId);

        if(member.isPresent()) {
            Member m = member.get();
            List<Order> findList = orderRepository.findAllByMember(m);
            return findList;
        }
        return null;
    }
}
