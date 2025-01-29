package com.example.Team2BE.Member.domain.repository;

import com.example.Team2BE.Member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member)
    {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override

    public Optional<Member> findByMemberId(String memberId) {
        return store.values().stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean deleteByMemberId(String memberId) {
        Optional<Member> member = findByMemberId(memberId);
        if (member.isPresent()) {
            Member m = member.get();
            store.remove(m.getId());
            return true;
        } else return false;
    }
}
