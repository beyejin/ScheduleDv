package com.example.scheduledevelop.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {
    private Long userid;
    private String title;
    private String content;

}
