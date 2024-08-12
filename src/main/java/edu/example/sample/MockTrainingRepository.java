package edu.example.sample;//package edu.example.training.repository;
//
//import edu.example.training.entity.Training;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MockTrainingRepository implements TrainingRepository {
//
//    @Override
//    public List<Training> selectAll() {
//        System.out.println("테스트 데이터 ----------------");
//
//        List<Training> trainings = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Training training = new Training();
//            training.setTitle("title" + i);
//
//            trainings.add(training);
//        }
//        return trainings;
//    }
//
//    @Override
//    public void selectTitle(String id) {
//
//    }
//}
