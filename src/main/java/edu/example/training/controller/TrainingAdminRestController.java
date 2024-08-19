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
//	•	    @RequestParam:
//        •	URL의 쿼리 파라미터(?key=value)나 POST 폼 데이터에서 값을 추출합니다.
//        •	주로 필터링, 페이징, 검색 등의 작업에 사용됩니다.
//	•	기본값 설정 및 필수 여부를 지정할 수 있습니다.
//        •	@PathVariable:
//        •	URL 경로의 일부를 변수로 추출하여 사용합니다.
//        •	RESTful API 설계에서 자주 사용되며, 리소스 식별에 유용합니다.
