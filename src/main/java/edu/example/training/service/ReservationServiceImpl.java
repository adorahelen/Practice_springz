package edu.example.training.service;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import edu.example.training.input.ReservationInput;
import edu.example.training.repository.ReservationRepository;
import edu.example.training.repository.StudentTypeRepository;
import edu.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
            // Value call
            Training t = trainingRepository.selectById(reservationInput.getTrainingId());


        // 예외 발생 시키지 (정원초과시)
        t.setReserved(t.getReserved() + 1);

        if(t.getReserved() > t.getCapacity())
        { System.out.println("Reservation has already been reserved"); }

        trainingRepository.update(t); // call Update
        //////////////////////////////////////////////
        StudentType st= studentTypeRepository.selectByCode(
                reservationInput.getStudentTypeCode()
        );

        Reservation reservation = new Reservation();
        reservation.setId(UUID.randomUUID().toString()); // 예약 Id 생성
        reservation.setTrainingId(t.getId());
        reservation.setStudentTypeId(st.getId());
        reservation.setName(reservation.getName());
        reservation.setPhone(reservation.getPhone());
        reservation.setEmailAddress(reservation.getEmailAddress());
        reservationRepository.insert(reservation);
        return reservation;
    }
}
