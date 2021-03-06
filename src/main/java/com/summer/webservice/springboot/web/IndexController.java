package com.summer.webservice.springboot.web;

import com.summer.webservice.springboot.config.auth.LoginUser;
import com.summer.webservice.springboot.config.auth.dto.SessionUser;
import com.summer.webservice.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
        // 머스타치 스타터 덕분에 경로와 파일 확장자는 자동으로 지정된다.
        // src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리
        // ViewResolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("post", postsService.findById(id));
        return "posts-update";
    }
}