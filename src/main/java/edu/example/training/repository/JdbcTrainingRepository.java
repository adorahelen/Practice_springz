package edu.example.training.repository;

import edu.example.training.entity.Training;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTrainingRepository implements TrainingRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTrainingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void selectTitle(String id) {
        String result = jdbcTemplate.queryForObject(
                "select title from training where id = ?",
                String.class, id);
        System.out.println("id: " + id);
        System.out.println("title: " + result);
    }

    @Override
    public void selectTitle(String id, String title) {
        String result = jdbcTemplate.queryForObject(
                "select title from training where id = ? AND title = ? ",
                String.class, id, title);
        System.out.println("id: " + id);
        System.out.println("title: " + result);

    }

    @Override
    public void selectStart(String id) {
        LocalDateTime result = jdbcTemplate.queryForObject(
                "select start_date_time from training where id = ? ",
                LocalDateTime.class, id);

        System.out.println("startDateTime: " + result);

    }

    @Override
    public void selectCount() {
        Integer result = jdbcTemplate.queryForObject(
                "select COUNT(*) FROM training ", Integer.class);

        System.out.println("count: " + result);
    }

    @Override
    public void selectReserveds() {
        List<Integer> result = jdbcTemplate.queryForList(
                    "select reserved FROM training ", Integer.class);
        for (Integer i : result) {
            System.out.println("reserved: " + i);
        }
    }

    @Override
    public void selectTrainingMap(String id) {
        Map<String, Object> result = jdbcTemplate.queryForMap(
                "select * from training where id = ?", id);

        result.forEach(( k, v) -> System.out.println("key: " + k + " value: " + v));
    }



    @Override
    public void selectTraining(String id) {
        Training result = jdbcTemplate.queryForObject(
                "select * from training where id = ? ",
                new DataClassRowMapper<>(Training.class), id);
                //Training.class, id);

        System.out.println("id: " + result);
    }

    @Override
    public void selectTrainingList() {
        List<Training> result = jdbcTemplate.query(
                "Select * from training ",
                new DataClassRowMapper<>(Training.class));
        result.forEach(System.out::println);
    }

    @Override
    public void insert(Training training) {
        int result = jdbcTemplate.update(
                " INSERT INTO training Values(?, ?, ?, ?, ?, ?) ",
                training.getId(),
                training.getTitle(),
                training.getStartDateTime(),
                training.getEndDateTime(),
                training.getReserved(),
                training.getCapacity() );
        System.out.println(result == 1 ? "inserted OK " : " NOT inserted");

    }

    @Override
    public void update(Training training) {
        int result = jdbcTemplate.update(
                "UPDATE training SET title = ?, capacity = ? WHERE id = ?"
                , training.getTitle(),  training.getCapacity() ,training.getId()
        );


        System.out.println(result == 1 ? "Update OK " : " NOT Update");

    }

    @Override
    public void delete(String id) {
        int result = jdbcTemplate.update(
                " DELETE FROM  training WHERE id = ? " , id);
        System.out.println(result == 1 ? "Delete OK " : " NOT Deleted");


    }

    @Override
    public void selectTrainingMapList() {
        List< Map<String, Object> > result = jdbcTemplate.queryForList(
                "select * from training ");

        result.forEach(System.out::println);
    }

    @Override
    public List<Training> selectAll() {
        System.out.println("DB에서 데이터 가져오기 --------");

        return List.of();
    }


}
