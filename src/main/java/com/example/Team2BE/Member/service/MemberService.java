package com.example.Team2BE.Member.service;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.domain.repository.MemberRepository;
import com.example.Team2BE.Member.domain.repository.MemoryMemberRepository;
import com.example.Team2BE.Member.dto.request.MemberRequest;
import com.example.Team2BE.Member.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private MemoryMemberRepository memoryMemberRepository;

    @Transactional
    public void createMember(String memberId, String password, String name){
        Member member = new Member(memberId, password, name);
        memoryMemberRepository.save(member);
    }

    @Transactional
    public boolean loginMember(String memberId, String password)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);
        if(member.isPresent()) {
            Member m = member.get();
            return password.equals(m.getPassword());
        }
        return false;
    }

    // 회원탈퇴
    @Transactional
    public boolean deleteMember(String memberId, String password)
    {
        return memoryMemberRepository.deleteByMemberId(memberId);
    }

    // 비밀번호 변경
    @Transactional
    public void updatePassword(String memberId, String password, String newPassword)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);
        if(member.isPresent())
        {
            Member m = member.get();
            if(m.getPassword().equals(password))
            {
                m.setPassword(newPassword);
            }
        }
    }

    // 정보 보기
    @Transactional
    public MyPageResponse getMyPage(String memberId)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);
        if(member.isPresent())
        {
            Member m = member.get();
            return MyPageResponse.from(m);
        }
        return null;
    }

}
