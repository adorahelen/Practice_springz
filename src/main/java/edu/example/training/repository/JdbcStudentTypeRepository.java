package edu.example.training.repository;

import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcStudentTypeRepository implements StudentTypeRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcStudentTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StudentType selectByCode(String studentTypeCode) {
        return jdbcTemplate.queryForObject(
                "select * from student_type where code = ? ",
                new DataClassRowMapper<>(StudentType.class),
                studentTypeCode
        );
    }

    @Override
    public List<StudentType> selectAllstudent() {
        return jdbcTemplate.query(
                " Select * from student_type ORDER BY id",
                new DataClassRowMapper<>(StudentType.class)
        );
    }

}
