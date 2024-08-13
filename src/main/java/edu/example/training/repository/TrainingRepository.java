package edu.example.training.repository;


import edu.example.training.entity.Training;

public interface TrainingRepository {

    Training selectById(String id);
    boolean update(Training training);
}
