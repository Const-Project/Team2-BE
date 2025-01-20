package com.example.Team2BE.Admin.domain.repository;

import com.example.Team2BE.Admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
//
//    List<Order> findAllOrders();
//
//    Double calculateTotalSales();
//
//    void removeMember(Long memberId);
//
//    List<Member> findAllMembers();
//
//    void updateMenuPrice(Object request);
//
//    void saveMenu(Object menu);

    Optional<Admin> save(Admin admin);
    Optional<Admin> findById(Long id);
    void deleteById(Long id);
    List<Admin> findAll();
}
