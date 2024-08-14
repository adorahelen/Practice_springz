package edu.example.training.service;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import edu.example.training.exception.CapacityOverException;
import edu.example.training.input.ReservationInput;
import edu.example.training.repository.ReservationRepository;
import edu.example.training.repository.StudentTypeRepository;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private TrainingRepository trainingRepository;
    private StudentTypeRepository studentTypeRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(TrainingRepository trainingRepository,
             StudentTypeRepository studentTypeRepository,
             ReservationRepository repository) {
        this.trainingRepository = trainingRepository;
        this.studentTypeRepository = studentTypeRepository;
        this.reservationRepository = repository;
        System.out.println("Reservation Service created");
    } // 이거 안쓰려면 @allargus ? @Noargus 써야함

    @Override
    public List<StudentType> getStudentTypes() {
        return studentTypeRepository.selectAllstudent();
    }
}
