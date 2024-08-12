package edu.example.training;

import com.zaxxer.hikari.HikariDataSource;
import edu.example.training.entity.Training;
import edu.example.training.service.TrainingService;
import edu.example.training.service.TrainingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.time.LocalDateTime;



@Configuration // 저절로 자바 컨피그 클래스가 되어, 골뱅이들을 빈으로 만들기 위해
@ComponentScan // 현재 패키지 부터 하위 모든 패키지를 포함하여 스테레오타입 어노테이션 클래스의 객체를 찾아 빈으로 관리, 골뱅이들 읽어오려고
public class TrainingApp {
    @Bean
    public DataSource dataSource() { // HikariCp 와 MySQl 로 데이터 소스 지정
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {return new JdbcTemplate(dataSource);}

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TrainingApp.class);
        TrainingService trainingService = context.getBean(TrainingServiceImpl.class);


        Training training = new Training("t04", "스프링 교육",
                LocalDateTime.of(2024, 7, 4, 9, 30, 00),
                LocalDateTime.of(2024, 7, 7, 17, 00, 00),
                0, 5);

        // trainingService.selectTrainingAll();
       // trainingService.deleteTraining("t04");
       // trainingService.updateTraining(training);
       // trainingService.insertTraining(training);

    }
}
