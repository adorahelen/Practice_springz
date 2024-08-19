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
    @Override
    public Reservation reserve(ReservationInput reservationInput) {
        //TrainingRepository의 selectById()를 호출하여 데이터를 받아온 후
        //reserved의 수를 1 추가하여 변경
        Training training = trainingRepository.selectById(
                reservationInput.getTrainingId());

        training.setReserved( training.getReserved() + 1 );

        //정원 초과인 경우 예외 발생 시키기 ---------------------------
        if(training.getReserved() > training.getCapacity()) {
            throw new CapacityOverException("정원 초과 예외 발생 - 예약 불가");
        }

        trainingRepository.update(training);    //update()를 호출

        ///////////////////////////////////////////////////////
        //StudentTypeRepository의 selectByCode()를 호출하여 수강생 유형을 가지고 온 후
        StudentType studentType
                = studentTypeRepository.selectByCode(
                reservationInput.getStudentTypeCode());

        //ReservationRepository의 insert()를 호출하여 레코드 추가
        //매개변수로 전달받은 ReservationInput 객체에서 필요한 정보들을
        //Reservation 객체를 생성하여 값을 저장한 후
        Reservation reservation = new Reservation();
        reservation.setId( UUID.randomUUID().toString() );  //예약 id 생성 및 저장
        reservation.setTrainingId(training.getId());
        reservation.setStudentTypeId(studentType.getId());
        reservation.setName(reservationInput.getName());
        reservation.setPhone(reservationInput.getPhone());
        reservation.setEmailAddress(reservationInput.getEmailAddress());
        reservationRepository.insert(reservation);

        return reservation;
    }
}
