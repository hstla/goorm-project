package com.goorm.tricountapi.interceptor;

import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.service.MemberService;
import com.goorm.tricountapi.util.MemberContext;
import com.goorm.tricountapi.util.SessionConst;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("로그인 인터셉터 시작");

        HttpSession session = request.getSession();
        Member sessionLoginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        log.info("sessionLoginMember={}", sessionLoginMember);

        if (session == null || sessionLoginMember == null) {
            log.info("미인증 사용자 요청 ");
            return false;
        }

        log.info("인증된 사용자 요청");
        try {
            // cookie에서 아이디를 꺼내고, DB에서 이 아이디에 해당하는 Member를 조회해서, set해준다.
            MemberContext.setCurrentMember(memberService.findMemberById(sessionLoginMember.getId()));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "MEMBER INFO SET ERROR" + e.getMessage());
        }
        return true;
    }
}
