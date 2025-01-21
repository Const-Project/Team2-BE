package com.example.Team2BE.Order.service;


import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.domain.repository.MemoryMemberRepository;
import com.example.Team2BE.Order.domain.Order;
import com.example.Team2BE.Order.domain.repository.MemoryOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    public MemoryOrderRepository memoryOrderRepository;
    public MemoryMemberRepository memoryMemberRepository;

    @Transactional
    public void createOrder(String menu, Long cost, Long quantity, Long isPacked, String memberId)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);
        if(member.isPresent()) {
            Member m = member.get();
            Order order = new Order(menu, cost, quantity, isPacked, m);
            memoryOrderRepository.save(order);
        }
    }

    @Transactional
    public void deleteOrder(String menu, Long quantity, String memberId)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);

        if(member.isPresent())
        {
            Member m = member.get();
            List<Order> findList = memoryOrderRepository.findAllByMember(m);
            for(Order order : findList)
            {
                if(menu.equals(order.getMenu()) && order.getQuantity().equals(quantity))
                {
                    memoryOrderRepository.deleteById(order.getId());
                }
            }
        }
    }

    @Transactional
    public List<Order> getOrderList(String memberId)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);

        if(member.isPresent()) {
            Member m = member.get();
            List<Order> findList = memoryOrderRepository.findAllByMember(m);
            return findList;
        }
        return null;
    }
}
