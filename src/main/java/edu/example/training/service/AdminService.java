package edu.example.training.service;

import edu.example.shopping.input.TrainingInput;
import edu.example.training.entity.Training;

import java.util.List;

public interface AdminService {
    Training findTrainingById(String trainingId);
    List<Training> findList();
    void modify(TrainingInput trainingInput);
    Training addTraining(TrainingInput trainingInput);
}
