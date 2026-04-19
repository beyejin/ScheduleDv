package com.example.scheduledevelop.user.entity;

import com.example.scheduledevelop.basic.entity.Base;
import com.example.scheduledevelop.user.dto.UserUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void update(UserUpdateRequest request) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
