package com.example.Team2BE.Member.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.domain.repository.MemberRepository;
import com.example.Team2BE.Member.domain.repository.MemoryMemberRepository;
import com.example.Team2BE.Member.dto.request.MemberRequest;
import com.example.Team2BE.Member.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @Autowired
    private MemoryMemberRepository memoryMemberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createMember(String memberId, String rawPassword, String name){
        String encryptedPassword = passwordEncoder.encode(rawPassword);
        Member member = new Member(memberId, encryptedPassword, name);
        memoryMemberRepository.save(member);
    }

    @Transactional
    public Member loginMember(String memberId, String rawPassword)
    {
        Optional<Member> member = memoryMemberRepository.findByMemberId(memberId);
        if(member.isPresent()) {
            Member m = member.get();
            if (passwordEncoder.matches(rawPassword, m.getPassword()))
            {
                return m;
            }
        }
        return null;
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
