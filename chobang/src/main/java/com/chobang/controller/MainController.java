package com.chobang.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/")
@RestController
public class MainController {
    @GetMapping(value = "/김주환")
    public String test() {
        return "김주환";
    }
}
