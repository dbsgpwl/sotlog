package com.sot.sotlog.api.controller;

import com.sot.sotlog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PostController {

    // SSR -> jsp, thymeleaf, mustache, freemarker
    // SPA -> vue, react
    //      vue, nuxt
    //      react, next

    // Http Method
    // GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
    // 글 등록: POST
                              // 1) request 클래스 생성하는 방법 @ModelAttribute PostCreate params
    @PostMapping("/posts") // = 2) @RequestParam Map<String, String> params
                             // = 3) @RequestParam String title, @RequestParam String content
    public String post(@RequestBody PostCreate params){
        log.info("params={}", params);
        return "hello";
    }
}
