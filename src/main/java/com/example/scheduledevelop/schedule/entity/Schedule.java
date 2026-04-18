package com.example.scheduledevelop.schedule.entity;

import com.example.scheduledevelop.basic.entity.Base;
import com.example.scheduledevelop.schedule.dto.ScheduleUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String content;

    public Schedule(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    /*// 일정 수정 메서드: 제목과 컨텐츠 변경 가능
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }*/

    // 일정 수정 메서드: 제목과 컨텐츠 변경 가능
    public void update (ScheduleUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }




}
