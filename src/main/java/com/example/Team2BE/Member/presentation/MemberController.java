package com.example.Team2BE.Member.presentation;


import com.example.Team2BE.Member.dto.request.MemberRequest;
import com.example.Team2BE.Member.dto.response.MyPageResponse;
import com.example.Team2BE.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
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
    public ResponseEntity<MyPageResponse> loginMemberRequest(@RequestBody MemberRequest request)
    {
        boolean isLogged = memberService.loginMember(request.getMemberId(), request.getPassword());
        if(isLogged) {
            MyPageResponse mypageResponse = memberService.getMyPage(request.getMemberId());
            return ResponseEntity.ok().body(mypageResponse);
        }
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
        MyPageResponse myPageResponse = memberService.getMypage(memberId);
        return ResponseEntity.ok().body(myPageResponse);
    }

}
