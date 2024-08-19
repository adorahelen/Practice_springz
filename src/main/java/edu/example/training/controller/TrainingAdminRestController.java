package edu.example.training.controller;

import edu.example.training.entity.Training;
import edu.example.training.service.TrainingService;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainingAdminRestController {
    private final TrainingService trainingService;
    // Rest APi : Not view, send "JSON"

    @GetMapping("/api/trainings")
    public List<Training> getTrainings() {
        return trainingService.findList();

    }

    @GetMapping("/api/trainings/{id}")
    public Training getTrainingId(@PathVariable String id) {

        return trainingService.findById(id);
    }
}
