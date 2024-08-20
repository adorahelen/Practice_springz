package edu.example.training.repository;

import edu.example.shopping.input.TrainingInput;
import edu.example.training.entity.Reservation;
import edu.example.training.entity.Training;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


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
                UPDATE training SET title = ?, start_date_time = ?, end_date_time = ?,
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

    // 여기가 문제인데 jpa쓰면,쿼리를 쓸 필요가 없다. 다만 컨트롤러나 서비스 작업이 추가 될?
    @Override
    public List<Training> selectList() {
        return jdbcTemplate.query(
                " Select * from training ORDER BY id",
                new DataClassRowMapper<>(Training.class)
        );
    }

    @Override
    public boolean insert(Training training) {

        int result = jdbcTemplate.update(
                """
                INSERT INTO training VALUES (?,?,?,?,?,?)
                """,
                training.getId(),
                training.getTitle(),
                training.getStartDateTime(),
                training.getEndDateTime(),
                training.getReserved(),
                training.getCapacity()

        );

        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        int result = jdbcTemplate.update("DELETE FROM training WHERE id = ?", id);

        return result == 1;
    }


}
