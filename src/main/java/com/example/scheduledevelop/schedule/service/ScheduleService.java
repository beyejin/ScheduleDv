package com.example.scheduledevelop.schedule.service;

import com.example.scheduledevelop.schedule.dto.*;
import com.example.scheduledevelop.schedule.entity.Schedule;
import com.example.scheduledevelop.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository; //레파지토리 가져옴

    // 저장
    @Transactional
    public ScheduleCreateResponse save(ScheduleCreateRequest request) {
        Schedule schedule = new Schedule(
                request.getUsername(),
                request.getTitle(),
                request.getContent()
        );
        Schedule savedschedule = scheduleRepository.save(schedule);

        return ScheduleCreateResponse.from(savedschedule);
    }

    // 다 건 조회
    @Transactional(readOnly = true)
    public List<ScheduleGetResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(ScheduleGetResponse::from).toList();
    }


    // 단 건 조회
    @Transactional(readOnly = true)
    public ScheduleGetResponse getByScheduleId(Long scheduleId) {
        Schedule savedSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );

        return ScheduleGetResponse.from(savedSchedule);

    }

    // 수정
    @Transactional
    public ScheduleUpdateResponse update(Long scheduleId, ScheduleUpdateRequest request) {
        Schedule updatedSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return ScheduleUpdateResponse.from(updatedSchedule);
    }

    // 삭제
    @Transactional
    public void delete(Long scheduleId) {
        Schedule deletedSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        scheduleRepository.delete(deletedSchedule);
    }


}
