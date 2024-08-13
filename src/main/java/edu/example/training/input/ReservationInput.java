package edu.example.training.input;
// DTO

import lombok.Data;


@Data
public class ReservationInput {
    private String trainingId;
    private String studentTypeId;
    private String name;
    private String phone;
    private String emailAddress;

}
