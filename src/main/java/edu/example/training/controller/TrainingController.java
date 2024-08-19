package edu.example.training.controller;

import edu.example.training.entity.Training;
import edu.example.training.service.TrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/training") // all mapping
public class TrainingController {
    private final TrainingService trainingService;


    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
        System.out.println("TrainingController created");
    }

    @GetMapping("/display-details")
    public String displayDetails(@RequestParam String trainingId, Model model) {
        Training training= trainingService.findById(trainingId);
        model.addAttribute("training", training);

// http://localhost:8080/training/display-details?trainingId=t03
        return "training/trainingDetails";

        //@RequestParam : 함수의 매개변수로 트래이닝 아이디와 모델(값=dto=input)
        // = trainingService.findById(trainingId); 아이디 넣고, 찾아온 값을 객체에 담는다
        //  model.addAttribute 코드를 통해, 키 값과 벨류 매칭으로 html(타임리프)에 보내면, 그쪽에서 값을 가져다 씀(html)
        // model.addAttribute("training", training):  =>
        // => 조회한 Training 객체를 Model 객체에 "training"이라는 이름으로 추가합니다.

    }
    @GetMapping("/display-List")
    public String displayDetailsList(Model model) {
      List<Training> trainings = trainingService.findList();
       model.addAttribute("trainingList", trainings);

        return "training/trainingList";
    }

}
