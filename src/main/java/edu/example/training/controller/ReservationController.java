package edu.example.training.controller;

import edu.example.training.entity.StudentType;
import edu.example.training.input.ReservationInput;
import edu.example.training.service.ReservationService;
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

    // 하나니까 안쓰고 저번에는 여로개로서 쓴거고 다 하기 싫으면 올알규스
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
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

        return "reservation/reservationConfirm";

    }



}
