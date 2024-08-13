package edu.example.training.repository;

import edu.example.training.entity.StudentType;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
