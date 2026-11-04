package com.example.cicdpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    /**
     * Explicit route mapping to serve the static index.html game page.
     */
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }
}
