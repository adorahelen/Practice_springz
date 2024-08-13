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

//    @Override
//    public boolean update(Training training) {
//        int result = jdbcTemplate.update(
//                """
//UPDATE training SET title = ?, description = ?, start_date = ?, end_date = ?
//                , reserved = ?, capacity = ?  WHERE id = ?""",
//                training.getTitle(),
//                //    public void update(Training training) {
//        int result = jdbcTemplate.update(
//                "UPDATE training SET title = ?, capacity = ? WHERE id = ?"
//                // 아래에 바인딩을 까먹지 말자
//                , training.getTitle(),  training.getCapacity() ,training.getId()
//        );
//
//
//        System.out.println(result == 1 ? "Update OK " : " NOT Update");
//
//    }

//        )
//    }
}
