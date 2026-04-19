package com.example.scheduledevelop.user.dto;

import com.example.scheduledevelop.schedule.entity.Schedule;
import com.example.scheduledevelop.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCreateResponse {
    private final Long id;
    private final String username;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    private UserCreateResponse(Long id, String username, String email, String password, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static UserCreateResponse from (User user) {
        return new UserCreateResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
}
