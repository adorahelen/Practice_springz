package edu.example.training.repository;

import edu.example.training.entity.Training;

import java.util.List;

public class JdbcTrainingRepository implements TrainingRepository {

    @Override
    public List<Training> selectAll() {
        System.out.println("DB에서 데이터 가져오기");
        return List.of();
    }
}
