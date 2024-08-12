package edu.example.training.service;

import edu.example.training.entity.Training;

import java.util.List;

public interface TrainingService {
    // 서비스에서 레포지토리를 찾고, 호출한다. 따라서 find
    // 서비스 -> 레포 -> 엔티티
    List<Training> findAll();
    void findTitle(String id);
    void findTitle(String id, String title);
    void findLocalDateTime(String id);
    void totalCount();
    void findReserved();
    void getTrainingMap(String id);
    void getTrainingMapList();
    void selectTraining(String id);
    void selectTrainingAll();
}

