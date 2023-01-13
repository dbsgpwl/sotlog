package com.sot.sotlog.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest //MockMvc 주입 시키는 어노테이션
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 hello 출력")
    void test() throws Exception {
        // expected
        mockMvc.perform(post("/posts")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("title", "글 제목입니다.")
//                        .param("content", "글 내용입니다.") // key : value
                                .contentType(MediaType.APPLICATION_JSON) // Header
                                .content("{\"title\": \"제목\", \"content\": \"내용\"}") // Body // -> MockHttpServletRequest:
        //                                                                                            HTTP Method = POST
        //                                                                                            Request URI = /posts
        //                                                                                            Parameters = {}
        //                                                                                            Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"40"]
        //                                                                                            Body = {"title": "제목", "content": "내용"}
        //                                                                                            Session Attrs = {}

                ) // application/json
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))  //andExpect: 기대한다
                .andDo(MockMvcResultHandlers.print()); // Http 요청에 대한 써머리를 로그에 찍어준다.


    }

}