package edu.example.training;

import edu.example.training.entity.Training;
import edu.example.training.repository.JdbcTrainingRepository;
import edu.example.training.repository.MockTrainingRepository;
import edu.example.training.repository.TrainingRepository;
import edu.example.training.service.TrainingService;
import edu.example.training.service.TrainingServiceImpl;

import java.util.List;

public class TrainingApp {
    public static void main(String[] args) {
        TrainingRepository tr = new JdbcTrainingRepository();
                            tr = new MockTrainingRepository();
                            // 이런 식으로 객체 생성 후 넘기는 작업을 빈이라고 하고, 이걸 스프링이 대신 진행하게 될 것이다. DI
        TrainingService ts = new TrainingServiceImpl(tr);
        List<Training> trainings = ts.findAll();
    }
}
