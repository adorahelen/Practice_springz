package edu.example.sample.controller;

import edu.example.sample.input.PageInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catalog") // 대표 맵핑 지정 , 클래스 전체에 적용
public class CatalogController {
    //@RequestMapping(path = "/catalog/abc", method = RequestMethod.GET)
    @RequestMapping(path = "/abc", method = RequestMethod.GET)
    public String abc() {
        System.out.println("===CatalogController: abc IS oK===");
        return "abc";
    }

    @GetMapping("/display-list4")
    public String displayList4(PageInput pageInput) {
        // 요청 파라미터가 많으면, 모델 객체로 받는다
        System.out.println("/catalog/display-list4");
        System.out.println("pageNum=" + pageInput.getPageNum());
        System.out.println("maxCount=" + pageInput.getMaxCount());
        System.out.println(pageInput);

        return "display";
    }
    @GetMapping("/display-list3")
    public String displayList3(@RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "10") int maxCount) {
        // 요청 파라미터가 전달되지 않은 경우 기본값
        System.out.println("/catalog/display-list3");
        System.out.println("pageNum=" + pageNum);
        System.out.println("maxCount=" + maxCount);

        return "display";
    }

    @GetMapping("/display-list2")
    public void displayList2(@RequestParam int pageNum,
                             @RequestParam int maxCount) {
        System.out.println("/catalog/display-list2");
        System.out.println("pageNum=" + pageNum);
        System.out.println("maxCount=" + maxCount);
    }


    @GetMapping("/display-list1")
    public void displayList1(@RequestParam("pageNum") int pNo,
                               @RequestParam("maxCount") int max) {
        // http://localhost:8080/catalog/display-list1  ' ?pageNum=1&maxCount=10 '
        // 쿼리 스트링 (물음표 뒤에, 추가적인 정보를 나타내는)
        // query parameters( 물음표 뒤에 = 로 연결된 key value pair 부분)을
        // url 뒤에 덧붙여서 추가적인 정보를 서버 측에 전달하는 것이다.
        // 클라이언트가 어떤 특정 리소스에 접근하고 싶어하는지 정보를 담는다.

        System.out.println("/catalog/display-list1");
        System.out.println("pageNum=" + pNo);
        System.out.println("maxCount=" + max);

        // return view 명시하지 않아도
        // 자동으로 요청 url과 같은 뷰를 찾는다
        // => templates/catalog/display-list1.html 이 자동으로 뷰로 지정
    }

//    @RequestMapping(path = "/catalog/xyz", method = RequestMethod.GET)
//    public String xyz() {
//        System.out.println("===CatalogController: xyz IS oK===");
//        return "xyz";
//    } 리퀘스트 매핑 쓰다가 겟 메핑이 만들어짐

    @GetMapping("/xyz")// view only
    public String xyz() {
        System.out.println("===CatalogController: xyz IS oK===");
        return "xyz";
    }
    @PostMapping ("/xyz") // prove
    public String xyzPost() {
        System.out.println("===CatalogController: xyzPost IS oK===");
        return "xyz";
    }
}
