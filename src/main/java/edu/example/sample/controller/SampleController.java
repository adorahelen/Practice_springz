package edu.example.sample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/display-sample")
    public String displaySample(Model model ) {
        // 뷰로 보낼 데이터는 모델 객체의 속성에 키와 값으로 추가
        // 보낼 데이터가 없으면 안쓰지만, (매핑만 하지만), 있다면 사용
        model.addAttribute("fullName", "Hello World!");
        return "sample";                   // 키             값
    }
    // 뷰 템플릿 파일 경로는 뷰리졸버가 스프링 부트 자동 설정을 따른다.
    // 자동 설정된 경로 : /src/resources/templates/뷰이름.html
    // [ prefix ]
} // localhost:8080/display-sample
