//package edu.example.training;
//
//import com.zaxxer.hikari.HikariDataSource;
//import edu.example.training.entity.Reservation;
//import edu.example.training.input.ReservationInput;
//import edu.example.training.service.ReservationService;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.JdbcTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//
//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.Logger;
//
//@Configuration // 저절로 자바 컨피그 클래스가 되어, 골뱅이들을 빈으로 만들기 위해
//@ComponentScan // 현재 패키지 부터 하위 모든 패키지를 포함하여 스테레오타입 어노테이션 클래스의 객체를 찾아 빈으로 관리, 골뱅이들 읽어오려고
//@EnableTransactionManagement
//public class TrainingApp {
//    @Bean
//    public DataSource dataSource() { // HikariCp 와 MySQl 로 데이터 소스 지정
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
//        dataSource.setUsername("root");
//        dataSource.setPassword("12345678");
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource)
//    {return new JdbcTemplate(dataSource);}
//
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource){
//        return new JdbcTransactionManager(dataSource);
//    }
//
//    public static void main(String[] args) {
//        ApplicationContext context
//                = new AnnotationConfigApplicationContext(TrainingApp.class);
//
//        ReservationService reservationService
//                = (ReservationService) context.getBean(ReservationService.class);
//
//        ((Logger) LoggerFactory.getLogger( JdbcTransactionManager.class )).setLevel(Level.DEBUG);
//
//        // Reserve Object
//        ReservationInput reservationInput = new ReservationInput();
//        reservationInput.setTrainingId("t03");
//        reservationInput.setName("KIM LEE PARK");
//        reservationInput.setPhone("010-1234-1234");
//        reservationInput.setEmailAddress("asd@asd");
//        reservationInput.setStudentTypeCode("FREELANCE");
//
//
//        Reservation reservation = reservationService.reserve(reservationInput);
//        System.out.println("Reserve ID " + reservation.getId());
//
//
//    }
//}
