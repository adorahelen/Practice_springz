package edu.example.training.input;
// DTO

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class ReservationInput {
    private String trainingId;

    @NotBlank
    private String studentTypeCode;

    @NotBlank
    private String name;

//    @NotBlank
//    @Pattern(regexp = "0\\d{1,4}-\\d{1,4}\\d{4}")
//    private String phone;

    @NotBlank
    @Pattern(regexp = "0\\d{1,2}-\\d{3,4}-\\d{4}")
    private String phone;

    @NotBlank
    @Email
    private String emailAddress;

}
