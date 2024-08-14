package edu.example.training.controller;

import edu.example.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/training") // all mapping
public class TrainingController {
    private final TrainingService trainingService;


    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
        System.out.println("TrainingController created");
    }

    @GetMapping("/display-details")
    public String displayDetails(Model model) {
        System.out.println("TrainingController display-details");
        return "training/trainingDetails";

    }

}
