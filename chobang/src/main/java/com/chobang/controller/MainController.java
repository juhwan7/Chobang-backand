package com.chobang.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@AllArgsConstructor
@RequestMapping("/")
@RestController
public class MainController {
    @GetMapping(value = "/김주환")
    public String test() {
        log.info("깃헙액션 테스트");
        return "김주환";
    }


}
