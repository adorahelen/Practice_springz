package edu.example.training.service;


import edu.example.training.entity.Training;
import edu.example.training.repository.JdbcTrainingRepository;
import edu.example.training.repository.MockTrainingRepository;
import edu.example.training.repository.TrainingRepository;

import java.util.List;


public class TrainingServiceImpl implements TrainingService{

    private TrainingRepository tr;

    public TrainingServiceImpl(TrainingRepository tr) {
        this.tr = tr;
    } // 이런 식으로 객체 생성 후 넘기는 작업을 빈이라고 하고, 이걸 스프링이 대신 진행하게 될 것이다. DI

    @Override
    public List<Training> findAll() {// 아래에 있는 강한 결합을 낮추기 위해서 (코드 일일이 고쳐야 하는)
     //  TrainingRepository tr = new JdbcTrainingRepository();
        //  tr = new MockTrainingRepository();
      return tr.selectAll();
    }
}
