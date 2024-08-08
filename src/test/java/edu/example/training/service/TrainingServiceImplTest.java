package edu.example.training.service;

import edu.example.training.entity.Training;
import edu.example.training.repository.JdbcTrainingRepository;
import edu.example.training.repository.MockTrainingRepository;
import edu.example.training.repository.TrainingRepository;
 // import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
// import org.assertj.*;
import static org.junit.jupiter.api.Assertions.assertNotNull; // 테스트 코드 3
import java.util.List;

import org.assertj.core.api.Assertions;



public class TrainingServiceImplTest {

    @Test // 테스트 코드 1
    public void testFindAll() {
        TrainingRepository tr = new JdbcTrainingRepository();
       // tr = new MockTrainingRepository();

        TrainingService ts = new TrainingServiceImpl(tr);
        assertNotNull(ts, "ts object null!"); // 테스트 코드 2
        ts.findAll();
        System.out.println("===============================");


        ts = new TrainingServiceImpl(new MockTrainingRepository());
        Assertions.assertThat(ts.findAll().size() ).isEqualTo(20);
        System.out.println("---------------------------------");
        ts = null;
        assertNotNull(ts, "ts object null!");

    }


}
//AssertJ에서는 assertThat 메서드를 AssertJ의 Assertions 클래스에서 바로 사용할 수 있지만,
//JUnit에서는 assertThat 메서드를 직접 사용할 수 없고 대신 org.junit.Assert 클래스를 통해서 사용가능해요!