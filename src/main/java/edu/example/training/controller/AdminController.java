package edu.example.training.controller;

import edu.example.shopping.input.TrainingInput;
import edu.example.training.entity.Training;
import edu.example.training.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PutMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyTraining(@PathVariable String id,
                               @Validated @RequestBody TrainingInput trainingInput) {
        trainingInput.setId(id);
        adminService.modify(trainingInput);

    }
    @GetMapping("/api/trainings/{id}")
    public Training getTrainings(@PathVariable String id) {
        return adminService.findTrainingById(id);
    }
    @GetMapping("/api/trainings")
    public List<Training> getAllTrainings() {
        return adminService.findList();
    }
}
