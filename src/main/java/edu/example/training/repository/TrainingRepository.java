package edu.example.training.repository;

import edu.example.training.entity.Training;

import java.util.List;

public interface TrainingRepository {
    List<Training> selectAll();

}
