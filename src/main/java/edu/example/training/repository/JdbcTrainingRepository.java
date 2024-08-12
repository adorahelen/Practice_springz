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
// @Profile("staging")
public class JdbcTrainingRepository implements TrainingRepository {
    // 이론상 위에 레포지토리 어노테이션이 기존의 것과 중복되기에 에러가 뜨지만
    // JVM 환경설정안에 프로파일 지정으로 해결하거나
    // OS 환경변수에 프로파일을 지정해서 해결 할 수 있다.

    // private final DataSource dataSource; 데이터 소스 빈
    private JdbcTemplate jdbcTemplate; // 제이디비씨 템플릿 빈ㄴ

    public JdbcTrainingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



// public JdbcTrainingRepository(DataSource dataSource) {
     //   this.dataSource = dataSource;
    //}

    // 한 컬럼 데이터 받아오기 - 검색 파라미터 하나
    @Override
    public void selectTitle(String id) {
      //  String query = "SELECT * FROM training WHERE id = ?";
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
//        System.out.println("title: " + result.getTitle());
//        System.out.println("startDateTime: " + result.getStartDateTime());
//        System.out.println("endDateTime: " + result.getEndDateTime());
//        System.out.println("reserved: " + result.getReserved());
//        System.out.println("capacity: " + result.getCapacity());
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

    }

    @Override
    public void delete(String id) {

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


//        try (Connection con = dataSource.getConnection();
//             Statement stmt = con.createStatement() ){
//            System.out.println("Con ok");
//            System.out.println("stmt ok");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        return List.of();
    }


}
