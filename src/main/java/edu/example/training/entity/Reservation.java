package edu.example.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;


import java.time.LocalDateTime;
@Data
@Setter
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
