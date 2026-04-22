package com.example.scheduledevelop.basic.controller;

import com.example.scheduledevelop.basic.SessionValue;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public abstract class BaseController {

    /**
     * 세션 여부를 확인함
     * session이 있는지 확인
     * null이 아니면 세션정보값 반환 아니면 예외 던짐
     */
    public SessionValue checkSession(HttpSession session) {
        SessionValue sessionValue = (SessionValue) session.getAttribute("sessionId");
        if (sessionValue == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요한 작업입니다.");
        }
        return sessionValue;
    }
}