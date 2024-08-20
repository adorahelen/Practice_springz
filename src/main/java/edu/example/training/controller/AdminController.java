package edu.example.training.controller;

import edu.example.shopping.input.TrainingInput;
import edu.example.training.entity.Training;
import edu.example.training.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/api/trainings")
    public ResponseEntity<Void> addTraining(@Validated @RequestBody TrainingInput trainingInput) {

       Training training = adminService.addTraining(trainingInput);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(training.getId()).toUri();
       return ResponseEntity.created(uri).build();
       // 기존 URL 뒤에, add 를 통해 새롭게 추가된 id에 따른 URI를 만들고 추가시킨 다음 반환한다. (기존 링크 뒤에 접미사를 추가한거임)
        // 생성됨-> http://localhost:8080/api/trainings/t99
    }
}