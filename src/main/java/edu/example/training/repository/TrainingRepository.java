package edu.example.training.repository;


import edu.example.training.entity.Training;

import java.util.List;

public interface TrainingRepository {

    Training selectById(String id);
    boolean update(Training training);
    List<Training> selectList();

    boolean insert(Training training);
    boolean delete(String id);
}
