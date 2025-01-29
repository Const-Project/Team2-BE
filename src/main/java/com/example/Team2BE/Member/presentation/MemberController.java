package com.example.Team2BE.Member.presentation;


import com.example.Team2BE.Member.domain.Member;
import com.example.Team2BE.Member.dto.request.MemberRequest;
import com.example.Team2BE.Member.dto.response.MyPageResponse;
import com.example.Team2BE.Member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입
    @PostMapping("/create")
    public ResponseEntity<Void> createMemberRequest(@RequestBody MemberRequest request)
    {
        memberService.createMember(request.getMemberId(), request.getPassword(), request.getName());
        return ResponseEntity.ok().build();
    }

    // 로그인
    @PostMapping
    public ResponseEntity<MyPageResponse> loginMemberRequest(@RequestBody MemberRequest request, HttpSession session, Model model)
    {
        Member member = memberService.loginMember(request.getMemberId(), request.getPassword());
        if(member != null) {
            session.setAttribute("member", member);
            MyPageResponse mypageResponse = memberService.getMyPage(request.getMemberId());
            return ResponseEntity.ok().body(mypageResponse);
        }
        model.addAttribute("Error", "Invalid username or password");
        return ResponseEntity.ok().body(new MyPageResponse("로그인 실패", "로그인 실패"));
    }
    // 로그아웃
    @GetMapping("/logout")
    public void logoutMemberRequest(HttpSession session) {
        session.invalidate(); // 세션 무효화
    }


    // 회원탈퇴
    @DeleteMapping("/{memberId}/delete")
    public ResponseEntity<Void> deleteMemberRequest(@PathVariable(name="memberId") String memberId, @RequestBody MemberRequest request)
    {
        boolean Deleted = memberService.deleteMember(memberId, request.getPassword());
        if(Deleted) return ResponseEntity.ok().build();
        else return ResponseEntity.status(401).build();
    }

    // 비밀번호 변경
    @PostMapping("/{memberId}/password")
    public ResponseEntity<Void> updatePasswordRequest(@RequestBody MemberRequest request)
    {
        memberService.updatePassword(request.getMemberId(), request.getPassword(), request.getNewPassword());
        return ResponseEntity.ok().build();
    }

    // 정보 보기
    @GetMapping("/{memberId}")
    public ResponseEntity<MyPageResponse> getMyPageRequest(@PathVariable(name="memberId") String memberId)
    {
        MyPageResponse myPageResponse = memberService.getMyPage(memberId);
        return ResponseEntity.ok().body(myPageResponse);
    }

}
