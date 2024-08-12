package edu.example.training.entity;

import lombok.Data;


import java.time.LocalDateTime;
@Data
public class Reservation {
    private String id;
    private String trainingId;
    private String studentTypeId;
    private LocalDateTime reservationDateTime;
    private String name;
    private String phone;
    private String emailAddress;

    private Training training;
    private StudentType studentType;
}
