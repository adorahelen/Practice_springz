package edu.example.training.controller;

import edu.example.training.entity.Reservation;
import edu.example.training.entity.StudentType;
import edu.example.training.entity.Training;
import edu.example.training.exception.CapacityOverException;
import edu.example.training.input.ReservationInput;
import edu.example.training.service.ReservationService;
import edu.example.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final TrainingService trainingService;

    // 하나니까 안쓰고 저번에는 여로개로서 쓴거고 다 하기 싫으면 올알규스
    public ReservationController(ReservationService reservationService, TrainingService trainingService) {

        this.reservationService = reservationService;
        this.trainingService = trainingService;
    }

    @GetMapping("/display-form")
    public String displayForm(@RequestParam String trainingId, Model model) {
        System.out.println("reservation form ok");

        // 입력값 유효성 검증시 사용자 선택항목 항목 저장하기 위한 객체
        ReservationInput reservationInput = new ReservationInput();
        reservationInput.setTrainingId(trainingId);
        model.addAttribute("reservationInput", reservationInput);

        List<StudentType> studentTypes = reservationService.getStudentTypes();
        model.addAttribute("studentTypeList", studentTypes);

        // http://localhost:8080/reservation/display-form?trainingId=t01
        return "reservation/reservationForm";
    }

    @PostMapping("/validate-input")
    public String validateInput(@Validated ReservationInput reservationInput,
                                BindingResult bindingResult, Model model){
        System.out.println("/reservation/validate-input");
        // ㅇㅣㅂ력 오류 는 원랴 화면 입력 오류 없으면 확인화면으로
        if (bindingResult.hasErrors()) {
            List<StudentType> studentTypes = reservationService.getStudentTypes();
            model.addAttribute("studentTypeList", studentTypes);
            return "reservation/reservationForm";
        }
        // 입력오류가 없을 경우 해당 트래이닝 정보를 가지고 화면으로 이동
        Training training = trainingService.findById(reservationInput.getTrainingId());
        model.addAttribute("training", training);
        return "reservation/reservationConfirm";

    }

    @PostMapping(value = "/reserve", params = "reserve") // 신청확정
    public String reserve(@Validated ReservationInput reservationInput,
                          Model model){
        // reservation 테이블에 추가하고
        Reservation reservation = reservationService.reserve(reservationInput);
        model.addAttribute("reservation", reservation);

        return "reservation/reservationCompleted";
    }

    @PostMapping(value = "/reserve", params = "correct") // 신청 내용 변경
    public String correctInput(@Validated ReservationInput reservationInput,
                                Model model) {
        List<StudentType> studentTypes = reservationService.getStudentTypes();
        model.addAttribute("studentTypeList", studentTypes);
        return "reservation/reservationForm";
    }

    @ExceptionHandler(CapacityOverException.class)
    public String handleCapacityOverException(Model model) {
        return "reservation/capacityOver";
    }


}