package edu.example.training.repository;

import edu.example.training.entity.Training;
import org.springframework.context.annotation.Profile;
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

    private final DataSource dataSource;

    public JdbcTrainingRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Training> selectAll() {
        System.out.println("DB에서 데이터 가져오기 --------");


        try (Connection con = dataSource.getConnection();
             Statement stmt = con.createStatement() ){
            System.out.println("Con ok");
            System.out.println("stmt ok");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }
}
