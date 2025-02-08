package com.example.Team2BE.Member.domain;

import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void MemoryMemberRepositoryTest()
    {
        memberService.createMember("hallo", "hallo", "오유준");
        Member m = memberService.loginMember("hallo", "hallo");
        if(m != null)
        {
            System.out.println("login success!");
        }
    }
}
