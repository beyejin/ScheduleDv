package com.example.scheduledevelop.auth.service;

import com.example.scheduledevelop.auth.dto.LoginRequest;
import com.example.scheduledevelop.user.entity.User;
import com.example.scheduledevelop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;

    @Transactional
    public User login(LoginRequest request) {
        User loginUser = userRepository.findByEmail(request.getEmail()).orElseThrow(
                        () -> new IllegalStateException("존재하지 않는 유저입니다."));

        if (!loginUser.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        return loginUser;
    }

}
