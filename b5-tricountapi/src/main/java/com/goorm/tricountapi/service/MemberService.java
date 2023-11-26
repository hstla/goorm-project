package com.goorm.tricountapi.service;

import com.goorm.tricountapi.dto.LoginRequest;
import com.goorm.tricountapi.dto.SignupRequest;
import com.goorm.tricountapi.enums.TricountApiErrorCode;
import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.repository.MemberRepository;
import com.goorm.tricountapi.util.TricountApiException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member signup(SignupRequest request) {
        return memberRepository.save(request.toMember());
    }

    public Member login(LoginRequest loginRequest) {
        Member findMember = memberRepository.findByLoginId(loginRequest.getLoginId())
            .orElseThrow(
                () -> new TricountApiException("존재하지 않는 회원입니다.", TricountApiErrorCode.NOT_FOUND));

        if (!findMember.matchPassword(loginRequest.getPassword())) {
            throw new TricountApiException("비밀번호가 일치하지 않습니다.", TricountApiErrorCode.INVALID_INPUT_VALUE);
        }
        return findMember;
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
