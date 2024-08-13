package edu.example.training.repository;

import edu.example.training.entity.Training;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcTrainingRepository implements TrainingRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTrainingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Training selectById(String id) {
        Training result = jdbcTemplate.queryForObject(
                "SELECT * FROM training WHERE id = ? ",
                new DataClassRowMapper<>(Training.class),id);
        return result;
    }

    @Override
    public boolean update(Training training) {
        int result = jdbcTemplate.update(
                """
                UPDATE training SET title = ?, start_date = ?, end_date = ?,
                reserved = ?, capacity = ? WHERE id = ?
                """,
                training.getTitle(),
                training.getStartDateTime(),
                training.getEndDateTime(),
                training.getReserved(),
                training.getCapacity(),
                training.getId()
        );

        return result > 0; // Return true if at least one row was updated, false otherwise
    }
}
