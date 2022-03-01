package com.shaneroach.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Capitalize {
    @GetMapping("/capitalize/{stringToCaps}")
    public String bffMethod(Model m, @PathVariable String stringToCaps){
        m.addAttribute("stringToCaps", stringToCaps.toUpperCase());
        return "capitalize.html";
    }
}
