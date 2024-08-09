package edu.example.training;

import com.zaxxer.hikari.HikariDataSource;
import edu.example.shopping.ShoppingApp;
import edu.example.training.entity.Training;
import edu.example.training.repository.JdbcTrainingRepository;
import edu.example.training.repository.MockTrainingRepository;
import edu.example.training.repository.TrainingRepository;
import edu.example.training.service.TrainingService;
import edu.example.training.service.TrainingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.List;

// @Import(ShoppingApp.class)
@Configuration // 저절로 자바 컨피그 클래스가 되어, 골뱅이들을 빈으로 만들기 위해
@ComponentScan // 현재 패키지 부터 하위 모든 패키지를 포함하여 스테레오타입 어노테이션 클래스의 객체를 찾아 빈으로 관리, 골뱅이들 읽어오려고
// @ComponentScan("com.example.traing") // 경로를 지정하여 컴포넌트 스캔
public class TrainingApp {
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }


    public static void main(String[] args) {
        //TrainingRepository tr = new JdbcTrainingRepository();
          //                  tr = new MockTrainingRepository();
        // 이런 식으로 객체 생성 후 넘기는 작업을 빈이라고 하고, 이걸 스프링이 대신 진행하게 될 것이다. DI

       // TrainingService ts = new TrainingServiceImpl(tr);
       // List<Training> trainings = ts.findAll();

        // 시스템 환경변수를 이용하여 Profile 지정
        // 이론상 위에 레포지토리 어노테이션이 기존의 것과 중복되기에 에러가 뜨지만
        // JVM 환경설정안에 프로파일 지정으로 해결하거나
        // OS 환경변수에 프로파일을 지정해서 해결 할 수 있다.
      //  System.setProperty("spring.profiles.active", "production");

     //   ApplicationContext context1= new AnnotationConfigApplicationContext(TrainingApp.class, ShoppingApp.class);
ApplicationContext context = new AnnotationConfigApplicationContext(TrainingApp.class);
        TrainingService ts = context.getBean(TrainingService.class);
        List<Training> trainings = ts.findAll();

    }
}
