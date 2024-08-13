package edu.example.training.repository;

import edu.example.training.entity.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcReservationRepository implements ReservationRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Reservation reservation) {
        return false;
    }
}
