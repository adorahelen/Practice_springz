package edu.example.sample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/display-sample")
    public String displaySample() {
        return "sample";
    }
} // localhost:8080/display-sample
