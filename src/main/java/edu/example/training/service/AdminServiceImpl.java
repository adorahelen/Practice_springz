package edu.example.training.service;

import edu.example.shopping.input.TrainingInput;
import edu.example.training.entity.Training;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{


    private final TrainingRepository trainingRepository;


    public AdminServiceImpl(TrainingRepository trainingRepository) {
       this.trainingRepository = trainingRepository;

   }

    @Override
    public Training findTrainingById(String trainingId) {
        return trainingRepository.selectById(trainingId);

    }

    @Override
    public List<Training> findList() {
        return trainingRepository.selectList();
    }

    @Override
    public void modify(TrainingInput trainingInput) {
        Training training = new Training(trainingInput.getId(),
                trainingInput.getTitle(),
                trainingInput.getStartDateTime(),
                trainingInput.getEndDateTime(),
                trainingInput.getReserved(),
                trainingInput.getCapacity(), null);

        trainingRepository.update(training);

    }

    @Override
    public Training addTraining(TrainingInput trainingInput) {
        Training training = new Training(trainingInput.getId(),
                trainingInput.getTitle(),
                trainingInput.getStartDateTime(),
                trainingInput.getEndDateTime(),
                trainingInput.getReserved(),
                trainingInput.getCapacity(), null);

        trainingRepository.insert(training);
        return training;
    }

    @Override
    public void deleteTraining(String trainingId) {
        trainingRepository.delete(trainingId);
    }
}
