package com.example.Team2BE.Admin.domain.repository;

import com.example.Team2BE.Admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    void deleteById(Long id);

}
