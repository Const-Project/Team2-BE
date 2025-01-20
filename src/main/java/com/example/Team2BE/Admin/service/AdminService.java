package com.example.Team2BE.Admin.service;

import com.example.Team2BE.Admin.domain.Admin;
import com.example.Team2BE.Admin.domain.repository.AdminRepository;
import com.example.Team2BE.Member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // 전체 주문 내역
    public List<Admin> getAllOrders() {
        return adminRepository.findAll();
    }

    // 매출 확인
    public Double getTotalSales() {
        List<Admin> admins = adminRepository.findAll();
        Double totalSales = 0.0;
        for (Admin admin : admins) {
            totalSales += admin.getMenuPrice();
        }
        return totalSales;
    }

    // 회원 강퇴
    public void deleteMember(Long memberId) {

    }

    // 회원 목록
    public List<Member> getAllMembers() {
        List<Admin> admins = adminRepository.findAll();
        List<Member> members = new ArrayList<>();
        for (Admin admin : admins) {

        }
        return members;
    }

    // 가격 변경
    public void changeMenuPrice(Admin admin) {

    }

    // 메뉴 추가
    public void createMenu(Object menu) {
    }
}
