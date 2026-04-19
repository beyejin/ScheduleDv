package com.example.scheduledevelop.user.controller;

import com.example.scheduledevelop.user.dto.*;
import com.example.scheduledevelop.user.entity.User;
import com.example.scheduledevelop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    //생성
    @PostMapping
    public ResponseEntity<UserCreateResponse> save(@RequestBody UserCreateRequest request) {
        UserCreateResponse result = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 다 건 조회
    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    // 단 건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserGetResponse> findById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    // 수정
    @PatchMapping("/{userId}")
    public ResponseEntity<UserUpdateResponse> updateById(@PathVariable Long userId, @RequestBody UserUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateById(userId,request));
    }

    //삭제

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletById(@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
