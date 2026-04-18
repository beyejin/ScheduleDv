package com.example.scheduledevelop.schedule.controller;

import com.example.scheduledevelop.schedule.dto.*;
import com.example.scheduledevelop.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 생성
    @PostMapping
    public ResponseEntity<ScheduleCreateResponse> createSchedule(
            @RequestBody ScheduleCreateRequest request) {
        ScheduleCreateResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 다 건 조회
    @GetMapping
    public ResponseEntity <List<ScheduleGetResponse>>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
    }

    // 단 건 조회
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleGetResponse> getByScheduleId(@PathVariable Long scheduleId) {
        ScheduleGetResponse result = scheduleService.getByScheduleId(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 수정
    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponse> Update(
            @PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequest request
    ){
        ScheduleUpdateResponse result = scheduleService.update(scheduleId,request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 삭제
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deletAll(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
