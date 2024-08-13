package edu.example.training.service;

import edu.example.training.entity.Reservation;
import edu.example.training.input.ReservationInput;
import edu.example.training.repository.ReservationRepository;
import edu.example.training.repository.StudentTypeRepository;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
    }



    @Override
    public Reservation reserve(ReservationInput reservationInput) {
        return null;
    }
}
