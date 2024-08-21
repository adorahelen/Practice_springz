package edu.example.training.service;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import edu.example.training.input.ReservationInput;
import edu.example.training.repository.StudentTypeRepository;

import java.util.List;

public interface ReservationService {

    public List<StudentType> getStudentTypes();


    Reservation reserve(ReservationInput reservationInput);

    Reservation findById(String id);

    Training findTrainingById(String id);
}
