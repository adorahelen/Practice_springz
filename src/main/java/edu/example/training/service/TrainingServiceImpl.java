package edu.example.training.service;


import edu.example.training.entity.Training;
import edu.example.training.repository.JdbcTrainingRepository;
import edu.example.training.repository.MockTrainingRepository;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService{
// @Service 를 통해 빈을 생성하고 @Autowired를 통해 의존성을 주입했다.

    @Autowired // 여기다 필드를 썼으니 인젝션 해줘
    private TrainingRepository trainingRepository;

    @Autowired // 생성자 인젝션  // 생성자 하나 일떼는 생략 가능
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    } // 이런 식으로 객체 생성 후 넘기는 작업을 빈이라고 하고, 이걸 스프링이 대신 진행하게 될 것이다. DI

    @Autowired // 세터 인젝션
    public void setTrainingRepository(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Training> findAll() {// 아래에 있는 강한 결합을 낮추기 위해서 (코드 일일이 고쳐야 하는)
        // IOC 제어의 역전 더 이상 개발자가 일일이 제어하지 않는다. 알아서 뉴 해서 넣어준다 @Authoried
     //  TrainingRepository tr = new JdbcTrainingRepository();
        //  tr = new MockTrainingRepository();
      return trainingRepository.selectAll();
    }
}
