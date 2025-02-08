package com.example.Team2BE.Member.domain.repository;

import com.example.Team2BE.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByMemberId(String memberId); // 아이디 존재 여부 확인

    Optional<Member> findByMemberId(String memberId);

    void deleteByMemberId(String memberId);
}
