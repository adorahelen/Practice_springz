package edu.example.training.controller;

import edu.example.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TrainingController {

    @Autowired
    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
        System.out.println("TrainingController created");
    }

}
