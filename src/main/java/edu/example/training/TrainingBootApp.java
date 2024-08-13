package edu.example.training;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.zaxxer.hikari.HikariDataSource;
import edu.example.training.entity.Reservation;
import edu.example.training.input.ReservationInput;
import edu.example.training.service.ReservationService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
public class TrainingBootApp {
    public static void main(String[] args) {
        ApplicationContext context
                = SpringApplication.run(TrainingBootApp.class);

        ReservationService reservationService
                = (ReservationService) context.getBean(ReservationService.class);

        // Reserve Object
        ReservationInput reservationInput = new ReservationInput();
        reservationInput.setTrainingId("t01");
        reservationInput.setName("KIM LEE PARK");
        reservationInput.setPhone("010-1234-1234");
        reservationInput.setEmailAddress("asd@asd");
        reservationInput.setStudentTypeCode("FREELANCE");


        Reservation reservation = reservationService.reserve(reservationInput);
        System.out.println("Reserve ID " + reservation.getId());


    }
}
