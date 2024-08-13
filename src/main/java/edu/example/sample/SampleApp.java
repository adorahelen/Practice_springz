package edu.example.sample;

import edu.example.training.entity.Reservation;
import edu.example.training.input.ReservationInput;
import edu.example.training.service.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SampleApp {
    public static void main(String[] args) {
        ApplicationContext context
                = SpringApplication.run(SampleApp.class);

    }
}
