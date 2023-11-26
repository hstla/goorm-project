package com.goorm.tricountapi.interceptor;

import com.goorm.tricountapi.util.SessionConst;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("로그인 인터셉터 시작");

        HttpSession session = request.getSession();
        log.info("--------------------------------------------------------------------------------------------------------------");
        log.info("session={}", session.getAttribute(SessionConst.LOGIN_MEMBER));
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            log.info("미인증 사용자 요청 ");
            return false;
        }
        return true;
    }
}
