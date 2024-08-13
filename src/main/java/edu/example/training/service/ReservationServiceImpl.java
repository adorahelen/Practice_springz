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
    }



    @Override
    public Reservation reserve(ReservationInput reservationInput) {
            // Value call
            Training training = trainingRepository.selectById(reservationInput.getTrainingId());


        // 예외 발생 시키지 (정원초과시)
        training.setReserved(training.getReserved() + 1);

        if(training.getReserved() > training.getCapacity()) {
            throw new CapacityOverException("정원 초과 - 에외 발생 !_! ");
        }


        trainingRepository.update(training); // call Update
        //////////////////////////////////////////////
        StudentType studentType= studentTypeRepository.selectByCode(
                reservationInput.getStudentTypeCode()
        );

        // 이 부분 문제였네
        Reservation reservation = new Reservation();
        reservation.setId(UUID.randomUUID().toString()); // 예약 Id 생성

        reservation.setTrainingId(training.getId());
        reservation.setStudentTypeId(studentType.getId());

        // 특히 여기 리설베이션이 아니라, 리설베이션 인풋이어야지, 리설베이션은 어디에도 없다
        reservation.setName(reservationInput.getName());
        reservation.setPhone(reservationInput.getPhone());
        reservation.setEmailAddress(reservationInput.getEmailAddress());

        reservationRepository.insert(reservation);
        return reservation;
    }
}
