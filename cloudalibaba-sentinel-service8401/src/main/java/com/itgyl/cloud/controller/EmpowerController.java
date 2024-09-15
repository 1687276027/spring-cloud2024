package com.itgyl.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpowerController {
    @GetMapping("/empower")
    public String empower() {
        return "spring cloud alibaba";
    }
}
