package com.summer.webservice.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
        // 머스타치 스타터 덕분에 경로와 파일 확장자는 자동으로 지정된다.
        // src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리
        // ViewResolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}