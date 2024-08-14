package edu.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {
    @RequestMapping(path = "/catalog/abc", method = RequestMethod.GET)
    public String abc() {
        System.out.println("===CatalogController: abc IS oK===");
        return "abc";
    }

//    @RequestMapping(path = "/catalog/xyz", method = RequestMethod.GET)
//    public String xyz() {
//        System.out.println("===CatalogController: xyz IS oK===");
//        return "xyz";
//    } 리퀘스트 매핑 쓰다가 겟 메핑이 만들어짐

    @GetMapping("/catalog/xyz")// view only
    public String xyz() {
        System.out.println("===CatalogController: xyz IS oK===");
        return "xyz";
    }
    @PostMapping ("/catalog/xyz") // prove
    public String xyzPost() {
        System.out.println("===CatalogController: xyzPost IS oK===");
        return "xyz";
    }
}
