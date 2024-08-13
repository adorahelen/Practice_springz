package edu.example.training.repository;

import edu.example.training.entity.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcReservationRepository implements ReservationRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Reservation reservation) {
        int result = jdbcTemplate.update("INSERT INTO Reservation VALUES(?, ?, ?, NOW(), ?, ?, ?)",
                reservation.getId(),
                reservation.getTrainingId(),
                reservation.getStudentTypeId(),
                reservation.getName(),
                reservation.getPhone(),
                reservation.getEmailAddress());
        return result == 1;
    }
}
