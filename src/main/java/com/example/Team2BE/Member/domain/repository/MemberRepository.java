package com.example.Team2BE.Member.domain.repository;

import com.example.Team2BE.Member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    void deleteByMemberId(String memberId);
    List<Member> findAll();
}
