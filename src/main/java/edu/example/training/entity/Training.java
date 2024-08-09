package edu.example.training.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 수강 신청 관련 - 강의 데이터를 갖는, Entity 클래스 - VO
public class Training {
    private String id;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer reserved;
    private Integer capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getReserved() {
        return reserved;
    }

    public void setReserved(Integer reserved) {
        this.reserved = reserved;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}