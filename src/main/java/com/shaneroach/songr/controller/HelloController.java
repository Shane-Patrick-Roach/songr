package com.shaneroach.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/hello-world")
    public String helloMethod()
    {
        return "Hello World";
    }
}
