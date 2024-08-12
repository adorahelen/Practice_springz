package edu.example.training.repository;

import edu.example.training.entity.Training;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
