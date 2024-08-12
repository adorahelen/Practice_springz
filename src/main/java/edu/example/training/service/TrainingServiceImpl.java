package edu.example.training.service;


import edu.example.training.entity.Training;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService{
// @Service 를 통해 빈을 생성하고 @Autowired를 통해 의존성을 주입했다.

    @Autowired // 여기다 필드를 썼으니 인젝션 해줘
    private TrainingRepository trainingRepository;

    @Override
    public List<Training> findAll() {// 아래에 있는 강한 결합을 낮추기 위해서 (코드 일일이 고쳐야 하는)

      return trainingRepository.selectAll();
    }

    @Override
    public void findTitle(String id) {
        trainingRepository.selectTitle(id);

    }

    @Override
    public void findTitle(String id, String title) {
        trainingRepository.selectTitle(id, title);

    }

    @Override
    public void findLocalDateTime(String id) {
        trainingRepository.selectStart(id);
    }

    @Override
    public void totalCount() {
        trainingRepository.selectCount();
    }

    @Override
    public void findReserved() {
        trainingRepository.selectReserveds();
    }

    @Override
    public void getTrainingMap(String id) {
        trainingRepository.selectTrainingMap(id);
    }

    @Override
    public void getTrainingMapList() {
        trainingRepository.selectTrainingMapList();
    }

    @Override
    public void selectTraining(String id) {
        trainingRepository.selectTraining(id);
    }

    @Override
    public void selectTrainingAll() {
        trainingRepository.selectTrainingList();
    }

    @Override
    public void insertTraining(Training training) {
        trainingRepository.insert(training);
    }

    @Override
    public void updateTraining(Training training) {
        trainingRepository.update(training);
    }

    @Override
    public void deleteTraining(String id) {
        trainingRepository.delete(id);

    }

}
