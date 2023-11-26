package com.goorm.tricountapi.controller;

import com.goorm.tricountapi.dto.LoginRequest;
import com.goorm.tricountapi.dto.SignupRequest;
import com.goorm.tricountapi.model.ApiResponse;
import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.service.MemberService;
import com.goorm.tricountapi.util.SessionConst;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<Member> signup(@Valid @RequestBody SignupRequest request) {
        return new ApiResponse<Member>().ok(memberService.signup(request));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse login(
        @Valid @RequestBody LoginRequest loginRequest,
        HttpServletRequest request
    ) {
        Member loginMember = memberService.login(loginRequest);

        // 세션이 있으면 있는 세션을 반환하고, 없으면 새로 생성해서 반환한다.
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return new ApiResponse().ok("로그인 성공");
    }

    // 로그아웃
    @PostMapping("/logout")
    public ApiResponse logout(HttpServletRequest request) {
        memberService.logout(request);
        return new ApiResponse().ok("로그아웃 되었습니다.");
    }
}